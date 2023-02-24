package me.arvis.Person.mocks;

import me.arvis.Person.dao.PersonDao;
import me.arvis.Person.enums.Gender;
import me.arvis.Person.repository.PersonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonRepository repository;

    @BeforeEach
    public void deleteAll() {
        repository.deleteAll();
    }


    @Test
    public void shouldRetrieveAllEntries() throws Exception {
        repository.save(new PersonDao("Hanna", "Mayer", "555",
                LocalDate.of(1985,6,20), Gender.FEMALE));
        repository.save(new PersonDao("John", "Doe", "789",
                LocalDate.of(2000,4,11), Gender.MALE));

        mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(
                jsonPath("$[1].firstName").value("John")).andExpect(
                jsonPath("$[1].personalId").value("789"));
    }

    @Test
    public void shouldSearchByPersonalId() throws Exception {
        PersonDao person = generatePersonDao();
        repository.save(person);
        mockMvc.perform(get("/"+person.getPersonalId()+"/"+ person.getDateOfBirth()))
                .andExpect(status().isOk())
                .andExpect(
                        jsonPath("$.firstName").value(person.getFirstName())).andExpect(
                        jsonPath("$.personalId").value(person.getPersonalId()));
    }

    // TODO: randomize all inputs
    // TODO: non existing person
    // TODO: incorrect URL
    // TODO: bad request


    private int generateRandomNumber(int min, int max){
        return new Random().nextInt(max - min + 1) + min;
    }

    private PersonDao generatePersonDao(){
        return new PersonDao("aaa",
                "bbbb",
                "zssdfd",

                LocalDate.of(2000,4,11),
                Gender.FEMALE);
    }


}
