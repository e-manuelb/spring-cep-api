package br.com.cep.api.shared.dtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class ConsultZipCodeDTOTest {
    @Test
    public void successCreateDTO() {
        ConsultZipCodeDTO consultZipCodeDTO = new ConsultZipCodeDTO("61801780");

        Assertions.assertEquals(consultZipCodeDTO.getCep(), "61801780");
    }
}
