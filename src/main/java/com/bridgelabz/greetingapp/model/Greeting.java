package com.bridgelabz.greetingapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Greeting {
    public void setMessage(String message) {
        this.message = message;
    }

    @Id
    private long id;
    private String message;

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Greeting() {
    }
    public Greeting(long l, String message) {
        this.id=l;
        this.message=message;
    }
}
