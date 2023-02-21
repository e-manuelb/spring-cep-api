package br.com.cep.api.domain.enums.cucumber;

import br.com.cep.api.domain.enums.ShippingPrice;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ShippingPriceStepdefs {
    @Given("I have a ShippingPrice enum")
    public void haveShippingPriceNum() {

    }

    @When("I invoke him")
    public void invokeHim() {

    }

    @Then("ShippingPrice must have correct values")
    public void mustHaveCorrectValues() {
        Assertions.assertEquals(ShippingPrice.NORTH.getPrice(), 20.83F);
        Assertions.assertEquals(ShippingPrice.NORTHEAST.getPrice(), 15.98F);
        Assertions.assertEquals(ShippingPrice.SOUTHEAST.getPrice(), 7.85F);
        Assertions.assertEquals(ShippingPrice.SOUTH.getPrice(), 17.30F);
        Assertions.assertEquals(ShippingPrice.MIDWEST.getPrice(), 12.50F);
    }
}
