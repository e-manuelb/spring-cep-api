package br.com.cep.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class Address implements Serializable {
    public String zipCode;
    public String address;
    public String complement;
    public String neighborhood;
    public String city;
    public String state;
    public Float shipping;
}
