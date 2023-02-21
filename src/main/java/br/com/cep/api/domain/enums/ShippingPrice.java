package br.com.cep.api.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShippingPrice {

    NORTH(20.83F),
    NORTHEAST(15.98F),
    SOUTHEAST(7.85F),
    SOUTH(17.30F),
    MIDWEST(12.50F);

    private Float price;

}
