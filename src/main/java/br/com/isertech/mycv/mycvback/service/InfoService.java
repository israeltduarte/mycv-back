package br.com.isertech.mycv.mycvback.service;

import br.com.isertech.mycv.mycvback.dto.InfoRequest;
import br.com.isertech.mycv.mycvback.entity.Info;
import br.com.isertech.mycv.mycvback.constants.Messages;
import br.com.isertech.mycv.mycvback.error.exception.InfoNotFoundException;
import br.com.isertech.mycv.mycvback.repository.InfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public List<Info> getAllInfos() {

        List<Info> infosList = infoRepository.findAll();

        log.info("InfoService#getAllInfos - List<Info>={}", infosList);

        return infosList;
    }

    public Info getInfo(String id) {

        Info info = infoRepository.findById(id)
                .orElseThrow(() -> new InfoNotFoundException(Messages.INFO_NOT_FOUND.concat(id)));

        log.info("InfoService#getInfo - Info={}", info);

        return info;
    }

    public Info addInfo(InfoRequest infoRequest) {

        Info info = Info.builder()
                .build();

        info = infoRepository.save(info);

        return info;
    }
}
