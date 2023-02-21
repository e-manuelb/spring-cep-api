package br.com.cep.api.domain.models.cucumber;

import br.com.cep.api.domain.models.Address;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AddressStepdefs {
    String expectedZipCode;
    String expectedAddress;
    String expectedComplement;
    String expectedNeighborhood;
    String expectedCity;
    String expectedState;
    Float expectedShipping;
    Address address;

    @Given("I have a Address")
    public void haveAddress() {

    }

    @When("I create the address")
    public void createAddress() {
        expectedZipCode = "12345678";
        expectedAddress = "Rua Teste";
        expectedComplement = "Complemento teste";
        expectedNeighborhood = "Bairro teste";
        expectedCity = "Cidade Teste";
        expectedState = "CE";
        expectedShipping = 10.0F;

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

    @Then("Address must have correct values")
    public void mustHaveCorrectValues() {
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
