package br.com.isertech.mycv.mycvback.transformer;

import br.com.isertech.mycv.mycvback.dto.*;
import br.com.isertech.mycv.mycvback.entity.*;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@UtilityClass
public class CurriculumTransformer {

    public static Curriculum fromCurriculumRequest(CurriculumRequest curriculumRequest) {

        return Curriculum.builder()
                .info(fromInfoRequest(curriculumRequest.getInfo()))
                .education(fromListEducationRequest(curriculumRequest.getEducation()))
                .certification(fromListCertificationRequest(curriculumRequest.getCertification()))
                .workingExperience(fromListWorkingExperienceRequest(curriculumRequest.getWorkingExperience()))
                .skill(fromListString(curriculumRequest.getSkill()))
                .language(fromListLanguageRequest(curriculumRequest.getLanguage()))
                .build();
    }

    private static Info fromInfoRequest(InfoRequest info) {

        return Info.builder()
                .name(info.getName())
                .location(info.getLocation())
                .mainPosition(info.getMainPosition())
                .birthdate(info.getBirthdate())
                .email(info.getEmail())
                .contact(info.getContact())
                .socialMedia(info.getSocialMedia())
                .introduction(info.getIntroduction())
                .build();
    }

    private static List<Education> fromListEducationRequest(List<EducationRequest> education) {

        List<Education> educationList = new ArrayList<>();

        education.forEach(item -> educationList.add(fromEducationRequest(item)));

        return educationList;
    }

    private static Education fromEducationRequest(EducationRequest educationRequest) {

        return Education.builder()
                .course(educationRequest.getCourse())
                .title(educationRequest.getTitle())
                .startDate(educationRequest.getStartDate())
                .endDate(educationRequest.getEndDate())
                .build();
    }

    private static List<Certification> fromListCertificationRequest(List<CertificationRequest> certification) {

        List<Certification> certificationList = new ArrayList<>();

        certification.forEach(item -> certificationList.add(fromCertificationRequest(item)));

        return certificationList;
    }

    private static Certification fromCertificationRequest(CertificationRequest item) {

        return Certification.builder()
                .description(item.getDescription())
                .date(item.getDate())
                .build();
    }

    private static List<WorkingExperience> fromListWorkingExperienceRequest(List<WorkingExperienceRequest> workingExperience) {

        List<WorkingExperience> workingExperienceList = new ArrayList<>();

        workingExperience.forEach(item -> workingExperienceList.add(fromWorkingExperienceRequest(item)));

        return workingExperienceList;
    }

    private static WorkingExperience fromWorkingExperienceRequest(WorkingExperienceRequest item) {

        return WorkingExperience.builder()
                .company(item.getCompany())
                .title(item.getTitle())
                .startDate(item.getStartDate())
                .endDate(item.getEndDate())
                .project(fromProjectRequest(item.getProject()))
                .build();
    }

    private static Project fromProjectRequest(ProjectRequest projectRequest) {

        return Project.builder()
                .description(projectRequest.getDescription())
                .stack(fromListString(projectRequest.getStack()))
                .build();
    }

    private static String fromListString(List<String> list) {

        StringBuilder skillsString = new StringBuilder();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            skillsString.append(iterator.next());
            if (iterator.hasNext()) {
                skillsString.append(", ");
            }
        }

        return skillsString.toString();
    }

    private static List<Language> fromListLanguageRequest(List<LanguageRequest> languageRequest) {

        List<Language> languageList = new ArrayList<>();

        languageRequest.forEach(item -> languageList.add(fromLanguageRequest(item)));

        return languageList;
    }

    private static Language fromLanguageRequest(LanguageRequest item) {

        return Language.builder()
                .name(item.getName())
                .level(item.getLevel())
                .build();
    }


}
