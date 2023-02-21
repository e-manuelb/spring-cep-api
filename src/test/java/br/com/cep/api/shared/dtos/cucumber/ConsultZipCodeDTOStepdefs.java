package br.com.cep.api.shared.dtos.cucumber;

import br.com.cep.api.shared.dtos.ConsultZipCodeDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ConsultZipCodeDTOStepdefs {
    ConsultZipCodeDTO consultZipCodeDTO;

    @Given("I have a ConsultZipCodeDTO")
    public void haveConsultZipCodeDTO() {

    }

    @When("I create the consultZipCodeDTO")
    public void createConsultZipCodeDTO() {
        consultZipCodeDTO = new ConsultZipCodeDTO("61801780");
    }

    @Then("ConsultZipDTO must have correct values")
    public void mustHaveCorrectValues() {
        Assertions.assertEquals(consultZipCodeDTO.getCep(), "61801780");
    }
}
