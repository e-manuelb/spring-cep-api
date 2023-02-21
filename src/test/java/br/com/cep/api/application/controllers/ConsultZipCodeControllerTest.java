package br.com.cep.api.application.controllers;

import br.com.cep.api.data.services.ConsultZipCodeService;
import br.com.cep.api.domain.features.ConsultZipCode;
import br.com.cep.api.domain.models.Address;
import br.com.cep.api.shared.dtos.AddressDTO;
import br.com.cep.api.shared.dtos.ConsultZipCodeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class ConsultZipCodeControllerTest {
    ConsultZipCode consultZipCode = Mockito.mock(ConsultZipCodeService.class);

    @Test
    public void shouldCallConsultZipCodeWithCorrectParams() throws Exception {
        String cep = "12345678";

        Mockito.when(consultZipCode.perform(cep)).thenReturn(
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

        ResponseEntity response = sut.consultZipCode(new ConsultZipCodeDTO(cep));

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody(),
                new AddressDTO("61801-780",
                        "Rua José Soares de Albuquerque",
                        "",
                        "São Bento",
                        "Pacatuba",
                        "CE",
                        15.98F));
    }

    @Test
    public void shouldRethrowIfConsultZipCodeThrows() throws Exception {
        String cep = "invalid";

        Mockito.when(consultZipCode.perform(cep)).thenThrow(new Exception("Service error."));

        ConsultZipCodeController sut = new ConsultZipCodeController(consultZipCode);

        Assertions.assertThrows(Exception.class, () -> {
            sut.consultZipCode(new ConsultZipCodeDTO(cep));
        });
    }
}