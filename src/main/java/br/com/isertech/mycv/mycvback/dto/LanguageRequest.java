package br.com.isertech.mycv.mycvback.dto;

import br.com.isertech.mycv.mycvback.enums.LanguageEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LanguageRequest {

    @NotBlank
    private String name;
    @NotBlank
    private LanguageEnum level;

}
