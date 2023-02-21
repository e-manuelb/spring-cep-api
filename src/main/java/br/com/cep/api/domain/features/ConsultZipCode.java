package br.com.cep.api.domain.features;

import br.com.cep.api.domain.models.Address;

public interface ConsultZipCode {
    public Address perform(String zipCode) throws Exception;
}
