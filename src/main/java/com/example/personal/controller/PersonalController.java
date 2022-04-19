package com.example.personal.controller;

import com.example.personal.Service.SequenceGeneratorService;
import com.example.personal.entity.Personal;
import com.example.personal.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Personal")
public class PersonalController {

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping
    public Personal save(@RequestBody Personal personal) {
        personal.setId(sequenceGeneratorService.generateSequence(Personal.SEQUENCE_NAME));
        return personalRepository.save(personal);
    }

    @GetMapping("/{dni}")
    public Personal find(@PathVariable String dni) {
        return personalRepository.findByDni(dni);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        personalRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Personal update(@PathVariable long id, @RequestBody Personal personal) {
        return personalRepository.save(personal);
    }

}
