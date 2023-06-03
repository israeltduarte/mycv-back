package br.com.isertech.mycv.mycvback.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mycv")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello");
    }

}
