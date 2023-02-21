package br.com.cep.api.data.services;

import br.com.cep.api.domain.enums.ShippingPrice;
import br.com.cep.api.domain.features.ConsultZipCode;
import br.com.cep.api.domain.models.Address;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultZipCodeService implements ConsultZipCode {

    private RestTemplate restTemplate;
    @Value("${cep-api.viacep.url}")
    private String viaCepURL;

    @Value("${cep-api.ibge.url}")
    private String ibgeURL;

    public ConsultZipCodeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Address perform(String zipCode) throws Exception {
        String viaCepURL = this.viaCepURL == null ? "https://viacep.com.br" : this.viaCepURL;
        String ibgeURL = this.ibgeURL == null ? "https://servicodados.ibge.gov.br/api/v1" : this.ibgeURL;

        ResponseEntity<String> viaCEPResponse = restTemplate.getForEntity(
                new StringBuilder()
                        .append(viaCepURL)
                        .append("/ws")
                        .append("/" + zipCode)
                        .append("/json")
                        .toString()
                , String.class);

        if (viaCEPResponse.getStatusCode() != HttpStatus.OK) {
            throw new Exception("Request error with status: " + viaCEPResponse.getStatusCode());
        }

        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootViaCEP = mapper.readTree(viaCEPResponse.getBody());

        ResponseEntity<String> ibgeResponse = restTemplate.getForEntity(
                new StringBuilder()
                        .append(ibgeURL)
                        .append("/localidades/estados/")
                        .append(rootViaCEP.path("uf").asText())
                        .append("/regioes-imediatas")
                        .toString(),
                String.class);

        System.out.println(new StringBuilder()
                .append(this.ibgeURL)
                .append("/localidades/estados/")
                .append(rootViaCEP.path("uf").asText())
                .append("/regioes-imediatas")
                .toString());

        Integer regionId = mapper.readTree(ibgeResponse.getBody()).path(0).path("regiao-intermediaria").path("UF").path("regiao").path("id").asInt();

        Float shippingPrice = switch (regionId) {
            case 1 -> ShippingPrice.NORTH.getPrice();
            case 2 -> ShippingPrice.NORTHEAST.getPrice();
            case 3 -> ShippingPrice.SOUTHEAST.getPrice();
            case 4 -> ShippingPrice.SOUTH.getPrice();
            case 5 -> ShippingPrice.MIDWEST.getPrice();
            default -> 0.0F;
        };

        return new Address(
                rootViaCEP.path("cep").asText(),
                rootViaCEP.path("logradouro").asText(),
                rootViaCEP.path("complemento").asText(),
                rootViaCEP.path("bairro").asText(),
                rootViaCEP.path("localidade").asText(),
                rootViaCEP.path("uf").asText(),
                shippingPrice
        );
    }
}
