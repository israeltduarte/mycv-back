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
@RequestMapping(value = "/mycv")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/infos")
    public ResponseEntity<List<Info>> getInfo() {

        List<Info> infosList = infoService.getAllInfos();

        return ResponseEntity.status(HttpStatus.OK).body(infosList);
    }

    @GetMapping("/infos/{id}")
    public ResponseEntity<Info> getInfo(@PathVariable String id) {

        Info info = infoService.getInfo(id);

        return ResponseEntity.status(HttpStatus.OK).body(info);
    }

    @PostMapping("/infos")
    public ResponseEntity<Info> addInfo(@RequestBody InfoRequest infoRequest) {

        Info info = infoService.addInfo(infoRequest);

        return ResponseEntity.status(HttpStatus.OK).body(info);
    }

}
