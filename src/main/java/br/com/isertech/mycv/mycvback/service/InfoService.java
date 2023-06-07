package br.com.isertech.mycv.mycvback.service;

import br.com.isertech.mycv.mycvback.constants.Messages;
import br.com.isertech.mycv.mycvback.dto.InfoRequest;
import br.com.isertech.mycv.mycvback.entity.Info;
import br.com.isertech.mycv.mycvback.error.exception.InfoNotFoundException;
import br.com.isertech.mycv.mycvback.repository.InfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    @Autowired
    private ModelMapper mapper;

    public List<Info> getAllInfos() {

        List<Info> infosList = infoRepository.findAll();

        log.info("InfoService#getAllInfos - List<Info>={}", infosList);

        return infosList;
    }

    public Info getInfo(String id) {

        Info info = infoRepository.findById(id).orElseThrow(() -> new InfoNotFoundException(Messages.INFO_NOT_FOUND.concat(id)));

        log.info("InfoService#getInfo - Info={}", info);

        return info;
    }

    public Info addInfo(InfoRequest infoRequest) {

        Info info = new Info();
        mapper.map(infoRequest, info);
        info = infoRepository.save(info);

        log.info("InfoService#addInfo - ".concat(Messages.INFO_CREATED.concat(info.toString())));

        return info;
    }

    public Info updateInfoById(InfoRequest infoRequest, String id) {

        Info info = infoRepository.findById(id).orElseThrow(() -> new InfoNotFoundException(Messages.INFO_NOT_FOUND.concat(id)));
        mapper.map(infoRequest, info);
        info.setId(id);
        info = infoRepository.save(info);

        log.info("InfoService#updateInfoById - ".concat(Messages.INFO_UPDATED.concat(id)));

        return info;
    }

    public void deleteInfoById(String id) {

        Info info = infoRepository.findById(id).orElseThrow(() -> new InfoNotFoundException(Messages.INFO_NOT_FOUND.concat(id)));
        infoRepository.delete(info);

        log.info("InfoService#deleteInfoById - ".concat(Messages.INFO_DELETED.concat(id)));
    }

    public void deleteAllInfos() {

        infoRepository.deleteAll();

        log.info("InfoService#deleteAllInfos - ".concat(Messages.INFOS_DELETED));
    }

}
