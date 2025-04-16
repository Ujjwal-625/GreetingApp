package com.bridgelabz.greetingapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Greeting {
    @Id
    private long id;
}
