package com.example.personal.controller;

import com.example.personal.entity.Personal;
import com.example.personal.repository.PersonalRepository;
import com.example.personal.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal")
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

    @Cacheable("personal")
    @GetMapping("/{dni}")
    public Personal find(@PathVariable String dni) throws InterruptedException {

        // Solo para pruebas de cache
        Thread.sleep(1000);

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
