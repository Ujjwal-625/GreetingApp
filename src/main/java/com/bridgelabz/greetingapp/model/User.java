package com.bridgelabz.greetingapp.model;


import jakarta.persistence.Entity;

//depnedency for db connection
//jpa
//mysql
public class User {
    private String firstName;
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
