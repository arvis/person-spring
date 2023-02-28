package me.arvis.Person.aspect;

import me.arvis.Person.dao.LogDao;
import me.arvis.Person.dao.PersonDao;
import me.arvis.Person.repository.LogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private LogRepository repository;

    private String fileName = "aspect_log.log";

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterReturning(
            pointcut="execution(* me.arvis.Person.controller.PersonController.all(..))",
            returning="result")
    public void afterReturningAllPersonAdvice(
            JoinPoint theJoinPoint, List<PersonDao> result) {
        repository.save(new LogDao("searched all items: " + result));
        writeToFile("searched all items: " + result);

    }

    @AfterReturning(
            pointcut="execution(* me.arvis.Person.controller.PersonController.getByIdAndDate(..))",
            returning="result")
    public void afterReturningSelectedPersonAdvice(
            JoinPoint theJoinPoint, List<PersonDao> result) {

        repository.save(new LogDao("searched with filters: " + result));
        writeToFile("checked for filters: " + result);
    }

    private void writeToFile(String textToWrite){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append("\n " +textToWrite);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
