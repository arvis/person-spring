package me.arvis.Person.repository;

import me.arvis.Person.dao.PersonDao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<PersonDao, Long> {
}
