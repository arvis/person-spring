package me.arvis.Person.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import me.arvis.Person.enums.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class LogDao {

    private @Id
    @GeneratedValue Long id;

    private LocalDateTime executionTime;

    private String message;

    LogDao(){}

    public LogDao(String message){
        this.executionTime = LocalDateTime.now();
        this.message = message;
    }


}
