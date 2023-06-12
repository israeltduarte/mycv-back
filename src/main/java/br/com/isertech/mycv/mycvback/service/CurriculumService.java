package br.com.isertech.mycv.mycvback.service;

import br.com.isertech.mycv.mycvback.constants.Messages;
import br.com.isertech.mycv.mycvback.dto.CurriculumRequest;
import br.com.isertech.mycv.mycvback.entity.Curriculum;
import br.com.isertech.mycv.mycvback.error.exception.CurriculumNotFoundException;
import br.com.isertech.mycv.mycvback.repository.CurriculumRepository;
import br.com.isertech.mycv.mycvback.transformer.CurriculumTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CurriculumService {

    @Autowired
    private CurriculumRepository curriculumRepository;

    public List<Curriculum> getAll() {

        List<Curriculum> curriculumsList = curriculumRepository.findAll();

        log.info("CurriculumService#getAll() - ".concat(Messages.CURRICULUMS).concat(curriculumsList.toString()));

        return curriculumsList;
    }

    public Curriculum getById(String id) {

        Curriculum curriculum = curriculumRepository.findById(id).orElseThrow(() -> new CurriculumNotFoundException(Messages.CURRICULUM_NOT_FOUND.concat(id)));

        log.info("CurriculumService#getById(id) - ".concat(Messages.CURRICULUM).concat(curriculum.toString()));

        return curriculum;
    }

    public Curriculum add(CurriculumRequest curriculumRequest) {

        Curriculum curriculum = CurriculumTransformer.fromCurriculumRequest(curriculumRequest);
        curriculum = curriculumRepository.save(curriculum);

        log.info("InfoService#addInfo - ".concat(Messages.INFO_CREATED.concat(curriculum.toString())));

        return curriculum;
    }

    public Curriculum updateById(CurriculumRequest curriculumRequest, String id) {

        Curriculum curriculum = CurriculumTransformer.fromCurriculumRequest(curriculumRequest);

        Curriculum curriculumInstance = curriculumRepository.findById(id).orElseThrow(() -> new CurriculumNotFoundException(Messages.CURRICULUM_NOT_FOUND.concat(id)));

        curriculum.setId(curriculumInstance.getId());

        curriculum = curriculumRepository.save(curriculum);

        log.info("CurriculumService#updateById - ".concat(Messages.CURRICULUM_UPDATED.concat(id)));

        return curriculum;
    }

    public void deleteById(String id) {

        Curriculum curriculum = curriculumRepository.findById(id).orElseThrow(() -> new CurriculumNotFoundException(Messages.CURRICULUM_NOT_FOUND.concat(id)));
        curriculumRepository.delete(curriculum);

        log.info("CurriculumService#deleteById - ".concat(Messages.CURRICULUM_DELETED.concat(id)));
    }

    public void deleteAll() {

        curriculumRepository.deleteAll();

        log.info("CurriculumService#deleteAll - ".concat(Messages.CURRICULUMS_DELETED));
    }
}
