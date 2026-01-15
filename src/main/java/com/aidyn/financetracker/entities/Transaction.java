package com.aidyn.financetracker.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// an entity represents one row in a table, something that can be saved or deleted, and has an ID (primary key)
// treat this class similarly to ddl.sql (just automatic creation instead of manual)
@Entity
@Table (name = "transactions") // initialize table in entity class used by jpa repo
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username; // check if this type is consistent 

    @Column(nullable = false, precision = 19, scale = 2) 
    private BigDecimal amount;

    @Column(nullable = false)
    private String category; // can also create a category entity maybe???!!!

    @Column(nullable = false)
    private LocalDate date;

    protected Transaction() {} // for JPA

    // Getters & Setters

    Long getId() { return id;}
    void setId(Long id) { this.id = id;}

    String getUsername() { return username;}
    void setUsername(String username) { this.username = username;}

    BigDecimal getAmount() { return amount;}
    void setAmount(BigDecimal amount) {this.amount = amount;}

    String getCategory() { return category;}
    void setCategory(String category) { this.category = category;}

    LocalDate getDate() { return date;}
    void setDate(LocalDate date) { this.date = date;}

} // need to create web page drop down for user input log
