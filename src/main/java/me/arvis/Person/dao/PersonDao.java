package me.arvis.Person.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import me.arvis.Person.enums.Gender;

import java.util.Date;

@Entity
public class PersonDao {
    private @Id
    @GeneratedValue Long id;

    private String firstName;

    private String lastName;

    private String personalId;

    private Gender gender;

    private Date dateOfBirth;

    PersonDao(){};

    public PersonDao(String firstName,String lastName, String personalId, Date dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalId = personalId;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
