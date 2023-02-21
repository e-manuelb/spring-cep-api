package br.com.cep.api.application.controllers.cucumber;

import br.com.cep.api.application.controllers.ConsultZipCodeController;
import br.com.cep.api.data.services.ConsultZipCodeService;
import br.com.cep.api.domain.features.ConsultZipCode;
import br.com.cep.api.domain.models.Address;
import br.com.cep.api.shared.dtos.AddressDTO;
import br.com.cep.api.shared.dtos.ConsultZipCodeDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ConsultZipCodeControllerStepdefs {
    String responseStatus;
    ConsultZipCode consultZipCode = Mockito.mock(ConsultZipCodeService.class);

    @Given("I have a correct zipCode")
    public void correctZipCode() {
        String zipCode = "12345678";
    }

    @When("^I search for the correct zipCode (\\d+)$")
    public void searchForTheCorrectZipCode(String zipCode) throws Exception {
        Mockito.when(consultZipCode.perform(zipCode)).thenReturn(
                new Address(
                        "61801-780",
                        "Rua José Soares de Albuquerque",
                        "",
                        "São Bento",
                        "Pacatuba",
                        "CE",
                        15.98F
                )
        );

        ConsultZipCodeController sut = new ConsultZipCodeController(consultZipCode);

        ResponseEntity response = sut.consultZipCode(new ConsultZipCodeDTO(zipCode));

        responseStatus = String.valueOf(response.getStatusCode());
    }

    @Then("^The response must be OK \"([^\"]*)\"$")
    public void theResultMustBeOK(String statusCode) {
        Assertions.assertEquals(responseStatus, statusCode);
    }

    @Given("I have a incorrect zipCode")
    public void incorrectZipCode() {
        String cep = "invalid";
    }

    @When("^I search for the incorrect zipCode (\\d+)$")
    public void searchForIncorrectZipCode(String zipCode) throws Exception {
        Mockito.when(consultZipCode.perform(zipCode)).thenThrow(new Exception("Service error."));
    }

    @Then("^I should have receive a exception with incorrect zipCode (\\d+)$")
    public void shouldHaveReceiveAException(String zipCode) {
        ConsultZipCodeController sut = new ConsultZipCodeController(consultZipCode);

        Assertions.assertThrows(Exception.class, () -> {
            sut.consultZipCode(new ConsultZipCodeDTO(zipCode));
        });
    }
}
