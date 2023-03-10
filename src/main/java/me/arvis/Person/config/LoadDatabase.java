package me.arvis.Person.config;

import me.arvis.Person.dao.PersonDao;
import me.arvis.Person.enums.Gender;
import me.arvis.Person.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Date;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PersonRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(
                    new PersonDao("John", "Doe", "123",
                            LocalDate.of(2000,4,11), Gender.MALE))
                    + repository.save(
                    new PersonDao("Ieva", "Liepina", "555",
                            LocalDate.of(1988,1,30), Gender.FEMALE))
            );
            log.info("Preloading " + repository.save(
                    new PersonDao("Janis", "Berzins", "45678",
                            LocalDate.of(1980,6,25), Gender.MALE)));

        };
    }

}
