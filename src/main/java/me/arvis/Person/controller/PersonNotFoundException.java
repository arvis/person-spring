package me.arvis.Person.controller;

public class PersonNotFoundException  extends RuntimeException{
    public PersonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonNotFoundException(String message) {
        super(message);
    }

    public PersonNotFoundException(Throwable cause) {
        super(cause);
    }

}
