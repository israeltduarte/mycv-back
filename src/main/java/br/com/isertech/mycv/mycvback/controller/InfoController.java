package br.com.isertech.mycv.mycvback.controller;

import br.com.isertech.mycv.mycvback.dto.InfoRequest;
import br.com.isertech.mycv.mycvback.entity.Info;
import br.com.isertech.mycv.mycvback.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/mycv/infos")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping
    public ResponseEntity<List<Info>> getInfo() {

        List<Info> infosList = infoService.getAllInfos();

        return ResponseEntity.status(HttpStatus.OK).body(infosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Info> getInfoById(@PathVariable String id) {

        Info info = infoService.getInfo(id);

        return ResponseEntity.status(HttpStatus.OK).body(info);
    }

    @PostMapping
    public ResponseEntity<Info> addInfo(@RequestBody InfoRequest infoRequest) {

        Info info = infoService.addInfo(infoRequest);

        return ResponseEntity.status(HttpStatus.OK).body(info);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInfoById(@PathVariable String id) {

        infoService.deleteInfoById(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllInfos() {

        infoService.deleteAllInfos();

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
