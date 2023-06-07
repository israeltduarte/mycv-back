package br.com.isertech.mycv.mycvback.controller;

import br.com.isertech.mycv.mycvback.dto.CurriculumRequest;
import br.com.isertech.mycv.mycvback.entity.Curriculum;
import br.com.isertech.mycv.mycvback.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/mycv/curriculums")
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;

    @GetMapping
    public ResponseEntity<List<Curriculum>> getAll() {

        List<Curriculum> curriculumList = curriculumService.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(curriculumList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculum> getById(@PathVariable String id) {

        Curriculum curriculum = curriculumService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(curriculum);
    }

    @PostMapping
    public ResponseEntity<Curriculum> add(@RequestBody CurriculumRequest curriculumRequest) {

        Curriculum curriculum = curriculumService.add(curriculumRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(curriculum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculum> update(@RequestBody CurriculumRequest curriculumRequest, @PathVariable String id) {

        Curriculum curriculum = curriculumService.updateById(curriculumRequest, id);

        return ResponseEntity.status(HttpStatus.OK).body(curriculum);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {

        curriculumService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {

        curriculumService.deleteAll();

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
