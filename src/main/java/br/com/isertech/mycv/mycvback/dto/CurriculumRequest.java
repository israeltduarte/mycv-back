package br.com.isertech.mycv.mycvback.dto;

import lombok.Data;

import java.util.List;

@Data
public class CurriculumRequest {

    private InfoRequest info;
    private List<EducationRequest> education;
    private List<CertificationRequest> certification;
    private List<WorkingExperienceRequest> workingExperience;
    private List<String> skill;
    private List<LanguageRequest> language;

}
