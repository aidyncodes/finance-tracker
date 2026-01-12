package com.aidyn.financetracker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// an entity represents one row in a table, something that can be saved or deleted, and has an ID (primary key)
@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;
}
