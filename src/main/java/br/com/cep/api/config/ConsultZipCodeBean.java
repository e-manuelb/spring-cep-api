package br.com.cep.api.config;

import br.com.cep.api.data.services.ConsultZipCodeService;
import br.com.cep.api.domain.features.ConsultZipCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsultZipCodeBean {

    private RestTemplate restTemplate;

    public ConsultZipCodeBean(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Bean
    public ConsultZipCode viaCepBean() {
        return new ConsultZipCodeService(this.restTemplate);
    }
}
