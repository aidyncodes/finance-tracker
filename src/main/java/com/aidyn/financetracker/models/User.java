package com.aidyn.financetracker.models;

import jakarta.persistence.Entity;

// TESTING PERIOD: NOT IN USE. instead i store username on Transaction directly 
@Entity
public class User {
    
    private final String username;

    private String firstName;
    
    private String lastName;
        
            public User(String username, String firstName, String lastName) {
                this.username = username;
                this.firstName = firstName;
                this.lastName = lastName;
    }

    // add setters and ensure all are protected... cybersecurity aspect. 

    String getUserId() { return username;}

    String getFirstName() { return firstName;}

    String getLastName() { return lastName;}

}
