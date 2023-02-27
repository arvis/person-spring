package me.arvis.Person.controller;

import me.arvis.Person.dao.PersonDao;
import me.arvis.Person.repository.PersonRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
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
    public List<PersonDao> getByIdAndDate(@PathVariable String personId,
                             @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        List<PersonDao> personsFound = repository.findByPersonalIdAndDateOfBirth(personId,localDate);
        if (personsFound.size()==0){
            throw new PersonNotFoundException("No person found with this personal Id and birth date");
        }
        return personsFound;
    }
}
