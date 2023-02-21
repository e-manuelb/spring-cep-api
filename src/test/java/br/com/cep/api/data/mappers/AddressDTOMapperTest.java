package br.com.cep.api.data.mappers;

import br.com.cep.api.domain.models.Address;
import br.com.cep.api.shared.dtos.AddressDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@Profile("test")
@SpringBootTest
public class AddressDTOMapperTest {
    @Test
    public void successMapTo() {
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

        AddressDTOMapper addressDTOMapper = new AddressDTOMapper();

        AddressDTO addressAfterMap = addressDTOMapper.mapTo(address);

        Assertions.assertNotNull(addressAfterMap);
        Assertions.assertNotNull(addressAfterMap.getCep());
        Assertions.assertNotNull(addressAfterMap.getLogradouro());
        Assertions.assertNotNull(addressAfterMap.getComplemento());
        Assertions.assertNotNull(addressAfterMap.getBairro());
        Assertions.assertNotNull(addressAfterMap.getCidade());
        Assertions.assertNotNull(addressAfterMap.getEstado());
        Assertions.assertNotNull(addressAfterMap.getFrete());
        Assertions.assertEquals(expectedZipCode, addressAfterMap.getCep());
        Assertions.assertEquals(expectedAddress, addressAfterMap.getLogradouro());
        Assertions.assertEquals(expectedComplement, addressAfterMap.getComplemento());
        Assertions.assertEquals(expectedNeighborhood, addressAfterMap.getBairro());
        Assertions.assertEquals(expectedCity, addressAfterMap.getCidade());
        Assertions.assertEquals(expectedState, addressAfterMap.getEstado());
        Assertions.assertEquals(expectedShipping, addressAfterMap.getFrete());
    }

    @Test
    public void successMapFrom() {
        final String expectedCEP = "12345678";
        final String expectedLogradouro = "Rua Teste";
        final String expectedComplemento = "Complemento teste";
        final String expectedBairro = "Bairro teste";
        final String expectedCidade = "Cidade Teste";
        final String expectedEstado = "CE";
        final Float expectedFrete = 10.0F;

        final AddressDTO addressDTO = new AddressDTO(
                expectedCEP,
                expectedLogradouro,
                expectedComplemento,
                expectedBairro,
                expectedCidade,
                expectedEstado,
                expectedFrete
        );

        AddressDTOMapper addressDTOMapper = new AddressDTOMapper();

        Address addressAfterMap = addressDTOMapper.mapFrom(addressDTO);

        Assertions.assertNotNull(addressAfterMap);
        Assertions.assertNotNull(addressAfterMap.getZipCode());
        Assertions.assertNotNull(addressAfterMap.getAddress());
        Assertions.assertNotNull(addressAfterMap.getComplement());
        Assertions.assertNotNull(addressAfterMap.getNeighborhood());
        Assertions.assertNotNull(addressAfterMap.getCity());
        Assertions.assertNotNull(addressAfterMap.getState());
        Assertions.assertNotNull(addressAfterMap.getShipping());
        Assertions.assertEquals(expectedCEP, addressAfterMap.getZipCode());
        Assertions.assertEquals(expectedLogradouro, addressAfterMap.getAddress());
        Assertions.assertEquals(expectedComplemento, addressAfterMap.getComplement());
        Assertions.assertEquals(expectedBairro, addressAfterMap.getNeighborhood());
        Assertions.assertEquals(expectedCidade, addressAfterMap.getCity());
        Assertions.assertEquals(expectedEstado, addressAfterMap.getState());
        Assertions.assertEquals(expectedFrete, addressAfterMap.getShipping());
    }
}
