package br.com.cep.api.data.mappers.cucumber;

import br.com.cep.api.data.mappers.AddressDTOMapper;
import br.com.cep.api.domain.models.Address;
import br.com.cep.api.shared.dtos.AddressDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class AddressDTOMapperStepdefs {
    String zipCode;
    Address address;
    AddressDTO addressDTO;

    @Given("I have a Address to convert to AddressDTO")
    public void haveAddress() {

    }

    @Then("I convert this Address to AddressDTO")
    public void convertAddressToAddressDTO() {
        final String expectedZipCode = "12345678";
        final String expectedAddress = "Rua Teste";
        final String expectedComplement = "Complemento teste";
        final String expectedNeighborhood = "Bairro teste";
        final String expectedCity = "Cidade Teste";
        final String expectedState = "CE";
        final Float expectedShipping = 10.0F;

        zipCode = expectedZipCode;

        address = new Address(
                expectedZipCode,
                expectedAddress,
                expectedComplement,
                expectedNeighborhood,
                expectedCity,
                expectedState,
                expectedShipping
        );
    }

    @Then("The AddressDTO must be formatted as well")
    public void addressDTOFormatted() {
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
        Assertions.assertEquals(address.getZipCode(), addressAfterMap.getCep());
        Assertions.assertEquals(address.getAddress(), addressAfterMap.getLogradouro());
        Assertions.assertEquals(address.getComplement(), addressAfterMap.getComplemento());
        Assertions.assertEquals(address.getNeighborhood(), addressAfterMap.getBairro());
        Assertions.assertEquals(address.getCity(), addressAfterMap.getCidade());
        Assertions.assertEquals(address.getState(), addressAfterMap.getEstado());
        Assertions.assertEquals(address.getShipping(), addressAfterMap.getFrete());
    }

    @Given("I have a AddressDTO to convert to Address")
    public void haveAddressDTO() {

    }

    @Then("I convert this AddressDTO to Address")
    public void convertAddressToAddress() {
        final String expectedCEP = "12345678";
        final String expectedLogradouro = "Rua Teste";
        final String expectedComplemento = "Complemento teste";
        final String expectedBairro = "Bairro teste";
        final String expectedCidade = "Cidade Teste";
        final String expectedEstado = "CE";
        final Float expectedFrete = 10.0F;

        addressDTO = new AddressDTO(
                expectedCEP,
                expectedLogradouro,
                expectedComplemento,
                expectedBairro,
                expectedCidade,
                expectedEstado,
                expectedFrete
        );
    }

    @Then("The Address must be formatted as well")
    public void addressFormatted() {
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
        Assertions.assertEquals(addressDTO.getCep(), addressAfterMap.getZipCode());
        Assertions.assertEquals(addressDTO.getLogradouro(), addressAfterMap.getAddress());
        Assertions.assertEquals(addressDTO.getComplemento(), addressAfterMap.getComplement());
        Assertions.assertEquals(addressDTO.getBairro(), addressAfterMap.getNeighborhood());
        Assertions.assertEquals(addressDTO.getCidade(), addressAfterMap.getCity());
        Assertions.assertEquals(addressDTO.getEstado(), addressAfterMap.getState());
        Assertions.assertEquals(addressDTO.getFrete(), addressAfterMap.getShipping());
    }

}
