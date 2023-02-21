package br.com.cep.api.data.mappers;

import br.com.cep.api.domain.models.Address;
import br.com.cep.api.domain.utils.Mapper;
import br.com.cep.api.shared.dtos.AddressDTO;

public class AddressDTOMapper extends Mapper<AddressDTO, Address> {
    @Override
    public Address mapFrom(AddressDTO param) {
        return new Address(
                param.getCep(),
                param.getLogradouro(),
                param.getComplemento(),
                param.getBairro(),
                param.getCidade(),
                param.getEstado(),
                param.getFrete()
        );
    }

    @Override
    public AddressDTO mapTo(Address param) {
        return new AddressDTO(
                param.getZipCode(),
                param.getAddress(),
                param.getComplement(),
                param.getNeighborhood(),
                param.getCity(),
                param.getState(),
                param.getShipping()
        );
    }
}
