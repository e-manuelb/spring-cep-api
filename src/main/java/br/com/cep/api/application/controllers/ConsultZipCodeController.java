package br.com.cep.api.application.controllers;

import br.com.cep.api.data.mappers.AddressDTOMapper;
import br.com.cep.api.domain.features.ConsultZipCode;
import br.com.cep.api.shared.dtos.ConsultZipCodeDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class
ConsultZipCodeController {
    private ConsultZipCode consultZipCodeService;

    private final AddressDTOMapper addressDTOMapper = new AddressDTOMapper();

    public ConsultZipCodeController(ConsultZipCode consultZipCodeService) {
        this.consultZipCodeService = consultZipCodeService;
    }

    @PostMapping("/consulta-cep")
    public ResponseEntity<?> consultZipCode(@Valid @RequestBody ConsultZipCodeDTO consultZipCodeDTO) throws Exception {
        return ResponseEntity.ok().body(this.addressDTOMapper.mapTo(this.consultZipCodeService.perform(consultZipCodeDTO.getCep())));
    }
}
