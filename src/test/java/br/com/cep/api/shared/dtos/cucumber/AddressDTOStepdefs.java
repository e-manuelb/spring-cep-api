package br.com.cep.api.shared.dtos.cucumber;

import br.com.cep.api.shared.dtos.AddressDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AddressDTOStepdefs {
    String expectedCEP;
    String expectedLogradouro;
    String expectedComplemento;
    String expectedBairro;
    String expectedCidade;
    String expectedEstado;
    Float expectedFrete;

    AddressDTO addressDTO;

    @Given("I have a AddressDTO")
    public void haveAddressDTO() {

    }

    @When("I create the addressDTO")
    public void createAddressDTO() {
        expectedCEP = "12345678";
        expectedLogradouro = "Rua Teste";
        expectedComplemento = "Complemento teste";
        expectedBairro = "Bairro teste";
        expectedCidade = "Cidade Teste";
        expectedEstado = "CE";
        expectedFrete = 10.0F;

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

    @Then("AddressDTO must have correct values")
    public void mustHaveCorrectValues() {
        Assertions.assertNotNull(addressDTO);
        Assertions.assertNotNull(addressDTO.getCep());
        Assertions.assertNotNull(addressDTO.getLogradouro());
        Assertions.assertNotNull(addressDTO.getComplemento());
        Assertions.assertNotNull(addressDTO.getBairro());
        Assertions.assertNotNull(addressDTO.getCidade());
        Assertions.assertNotNull(addressDTO.getEstado());
        Assertions.assertNotNull(addressDTO.getFrete());
        Assertions.assertEquals(expectedCEP, addressDTO.getCep());
        Assertions.assertEquals(expectedLogradouro, addressDTO.getLogradouro());
        Assertions.assertEquals(expectedComplemento, addressDTO.getComplemento());
        Assertions.assertEquals(expectedBairro, addressDTO.getBairro());
        Assertions.assertEquals(expectedCidade, addressDTO.getCidade());
        Assertions.assertEquals(expectedEstado, addressDTO.getEstado());
        Assertions.assertEquals(expectedFrete, addressDTO.getFrete());
    }
}
