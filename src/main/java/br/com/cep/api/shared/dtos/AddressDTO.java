package br.com.cep.api.shared.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AddressDTO implements Serializable {
    public String cep;
    public String logradouro;
    public String complemento;
    public String bairro;
    public String cidade;
    public String estado;
    public Float frete;
}
