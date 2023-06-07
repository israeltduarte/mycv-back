package br.com.isertech.mycv.mycvback.dto;

import lombok.Data;

@Data
public class WorkingExperienceRequest {

    private String company;
    private String startDate;
    private String endDate;
    private String title;
    private ProjectRequest project;


}
