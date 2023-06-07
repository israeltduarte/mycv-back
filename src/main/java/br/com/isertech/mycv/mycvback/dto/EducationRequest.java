package br.com.isertech.mycv.mycvback.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EducationRequest {

    @NotBlank
    private String course;
    private String title;
    private String startDate;
    private String endDate;

}
