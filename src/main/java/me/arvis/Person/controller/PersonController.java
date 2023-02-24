package me.arvis.Person.controller;

import me.arvis.Person.dao.PersonDao;
import me.arvis.Person.repository.PersonRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class PersonController {

    private final PersonRepository repository;

    PersonController(PersonRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    public List<PersonDao> all() {
        return repository.findAll();
    }

    @GetMapping("/{personId}/{localDate}")
    public PersonDao getByIdAndDate(@PathVariable String personId,
                             @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        //new Date(2000, 11, 21)
        LocalDate dateTime = LocalDate.of(2000,4,11);
        return repository.findByPersonalIdAndDateOfBirth(personId,localDate).get(0);
    }

//    @PostMapping("/local-date")
//    public void localDate(@RequestParam("localDate")
//                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
//        // ...
//    }

}
