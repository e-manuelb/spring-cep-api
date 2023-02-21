package br.com.cep.api.domain.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class AddressTest {
    @Test
    public void successCreateModel() {
        final String expectedZipCode = "12345678";
        final String expectedAddress = "Rua Teste";
        final String expectedComplement = "Complemento teste";
        final String expectedNeighborhood = "Bairro teste";
        final String expectedCity = "Cidade Teste";
        final String expectedState = "CE";
        final Float expectedShipping = 10.0F;

        final Address address = new Address(
                expectedZipCode,
                expectedAddress,
                expectedComplement,
                expectedNeighborhood,
                expectedCity,
                expectedState,
                expectedShipping
        );

        Assertions.assertNotNull(address);
        Assertions.assertNotNull(address.getZipCode());
        Assertions.assertNotNull(address.getAddress());
        Assertions.assertNotNull(address.getComplement());
        Assertions.assertNotNull(address.getNeighborhood());
        Assertions.assertNotNull(address.getCity());
        Assertions.assertNotNull(address.getState());
        Assertions.assertNotNull(address.getShipping());
        Assertions.assertEquals(expectedZipCode, address.getZipCode());
        Assertions.assertEquals(expectedAddress, address.getAddress());
        Assertions.assertEquals(expectedComplement, address.getComplement());
        Assertions.assertEquals(expectedNeighborhood, address.getNeighborhood());
        Assertions.assertEquals(expectedCity, address.getCity());
        Assertions.assertEquals(expectedState, address.getState());
        Assertions.assertEquals(expectedShipping, address.getShipping());
    }
}
