package br.com.isertech.mycv.mycvback.configuration;

import br.com.isertech.mycv.mycvback.dto.CurriculumRequest;
import br.com.isertech.mycv.mycvback.dto.InfoRequest;
import br.com.isertech.mycv.mycvback.entity.Curriculum;
import br.com.isertech.mycv.mycvback.entity.Info;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper mapper = new ModelMapper();

        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        convertFromCurriculumRequestToCurriculum(mapper);
//        convertFromInfoRequestToInfo(mapper);

        return mapper;
    }

    private void convertFromCurriculumRequestToCurriculum(ModelMapper mapper) {
        mapper.createTypeMap(CurriculumRequest.class, Curriculum.class).addMappings(mapping -> {
//            mapping.map(CurriculumRequest::getInfo, Curriculum::setInfo);
            mapping.map(CurriculumRequest::getEducation, Curriculum::setEducation);
            mapping.map(CurriculumRequest::getCertification, Curriculum::setCertification);
            mapping.map(CurriculumRequest::getWorkingExperience, Curriculum::setWorkingExperience);
            mapping.map(CurriculumRequest::getLanguage, Curriculum::setLanguage);
            mapping.map(CurriculumRequest::getSkill, Curriculum::setSkill);
        });
    }

//    private void convertFromInfoRequestToInfo(ModelMapper mapper) {
//        mapper.createTypeMap(InfoRequest.class, Info.class).addMappings(mapping -> {
//            mapping.map(InfoRequest::getName, Info::setName);
//            mapping.map(InfoRequest::getLocation, Info::setLocation);
//            mapping.map(InfoRequest::getBirthdate, Info::setBirthdate);
//            mapping.map(InfoRequest::getContact, Info::setContact);
//            mapping.map(InfoRequest::getIntroduction, Info::setIntroduction);
//            mapping.map(InfoRequest::getEmail, Info::setEmail);
//            mapping.map(InfoRequest::getSocialMedia, Info::setSocialMedia);
//            mapping.map(InfoRequest::getMainPosition, Info::setMainPosition);
//        });
//    }
}