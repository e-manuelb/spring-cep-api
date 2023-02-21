package br.com.cep.api.domain.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class ShippingPriceTest {
    @Test
    public void successGetEnums() {
        Assertions.assertEquals(ShippingPrice.NORTH.getPrice(), 20.83F);
        Assertions.assertEquals(ShippingPrice.NORTHEAST.getPrice(), 15.98F);
        Assertions.assertEquals(ShippingPrice.SOUTHEAST.getPrice(), 7.85F);
        Assertions.assertEquals(ShippingPrice.SOUTH.getPrice(), 17.30F);
        Assertions.assertEquals(ShippingPrice.MIDWEST.getPrice(), 12.50F);
    }
}
