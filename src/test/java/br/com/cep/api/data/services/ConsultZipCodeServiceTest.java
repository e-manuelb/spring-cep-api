package br.com.cep.api.data.services;

import br.com.cep.api.domain.enums.ShippingPrice;
import br.com.cep.api.domain.models.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@ActiveProfiles("test")
public class ConsultZipCodeServiceTest {

    @Test
    public void successConsultZip() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        ConsultZipCodeService consultZipCodeService = new ConsultZipCodeService(restTemplate);

        String cep = "01001-000";

        Address address = consultZipCodeService.perform(cep);

        Assertions.assertNotNull(address);
        Assertions.assertNotNull(address.getZipCode());
        Assertions.assertNotNull(address.getAddress());
        Assertions.assertNotNull(address.getComplement());
        Assertions.assertNotNull(address.getNeighborhood());
        Assertions.assertNotNull(address.getCity());
        Assertions.assertNotNull(address.getState());
        Assertions.assertNotNull(address.getShipping());
        Assertions.assertEquals("01001-000", address.getZipCode());
        Assertions.assertEquals("Praça da Sé", address.getAddress());
        Assertions.assertEquals("lado ímpar", address.getComplement());
        Assertions.assertEquals("Sé", address.getNeighborhood());
        Assertions.assertEquals("São Paulo", address.getCity());
        Assertions.assertEquals("SP", address.getState());
        Assertions.assertEquals(ShippingPrice.SOUTHEAST.getPrice(), address.getShipping());
    }
}
