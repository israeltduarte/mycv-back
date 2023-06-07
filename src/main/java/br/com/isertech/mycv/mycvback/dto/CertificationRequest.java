package br.com.isertech.mycv.mycvback.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CertificationRequest {

    @NotBlank
    private String description;
    private String date;

}
