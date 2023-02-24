package me.arvis.Person.controller;

import me.arvis.Person.dao.PersonDao;
import me.arvis.Person.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PersonController {

    private final PersonRepository repository;

    PersonController(PersonRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    List<PersonDao> all() {
        return repository.findAll();
    }
}
