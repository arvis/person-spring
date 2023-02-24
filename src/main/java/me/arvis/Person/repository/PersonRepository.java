package me.arvis.Person.repository;

import me.arvis.Person.dao.PersonDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


//CrudRepository
//import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends JpaRepository<PersonDao, Long> {

    List<PersonDao> findByPersonalIdAndDateOfBirth(String personalId, LocalDate dateOfBirth);

}

