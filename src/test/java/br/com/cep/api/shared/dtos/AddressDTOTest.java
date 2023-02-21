package br.com.cep.api.shared.dtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class AddressDTOTest {
    @Test
    public void successCreateDTO() {
        final String expectedCEP = "12345678";
        final String expectedLogradouro = "Rua Teste";
        final String expectedComplemento = "Complemento teste";
        final String expectedBairro = "Bairro teste";
        final String expectedCidade = "Cidade Teste";
        final String expectedEstado = "CE";
        final Float expectedFrete = 10.0F;

        final AddressDTO addressDTO = new AddressDTO(
                expectedCEP,
                expectedLogradouro,
                expectedComplemento,
                expectedBairro,
                expectedCidade,
                expectedEstado,
                expectedFrete
        );

        Assertions.assertNotNull(addressDTO);
        Assertions.assertNotNull(addressDTO.getCep());
        Assertions.assertNotNull(addressDTO.getLogradouro());
        Assertions.assertNotNull(addressDTO.getComplemento());
        Assertions.assertNotNull(addressDTO.getBairro());
        Assertions.assertNotNull(addressDTO.getCidade());
        Assertions.assertNotNull(addressDTO.getEstado());
        Assertions.assertNotNull(addressDTO.getFrete());
        Assertions.assertEquals(expectedCEP, addressDTO.getCep());
        Assertions.assertEquals(expectedLogradouro, addressDTO.getLogradouro());
        Assertions.assertEquals(expectedComplemento, addressDTO.getComplemento());
        Assertions.assertEquals(expectedBairro, addressDTO.getBairro());
        Assertions.assertEquals(expectedCidade, addressDTO.getCidade());
        Assertions.assertEquals(expectedEstado, addressDTO.getEstado());
        Assertions.assertEquals(expectedFrete, addressDTO.getFrete());
    }
}
