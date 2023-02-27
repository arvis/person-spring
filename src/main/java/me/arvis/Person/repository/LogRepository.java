package me.arvis.Person.repository;

import me.arvis.Person.dao.LogDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogDao, Long> {

}
