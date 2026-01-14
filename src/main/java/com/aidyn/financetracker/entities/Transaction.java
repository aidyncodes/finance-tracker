package com.aidyn.financetracker.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// an entity represents one row in a table, something that can be saved or deleted, and has an ID (primary key)
@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long username;
    private BigDecimal amount;
    private String category; // can also create a category entity maybe???!!!
    private LocalDate date;
}
