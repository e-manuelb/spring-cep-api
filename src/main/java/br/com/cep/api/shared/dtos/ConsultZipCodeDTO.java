package br.com.cep.api.shared.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultZipCodeDTO {

    @NotEmpty(message = "CEP is required.")
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE}, message = "CEP is invalid.")
    private String cep;
}
