package com.aidyn.financetracker.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aidyn.financetracker.dto.CategoryTotal;
import com.aidyn.financetracker.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query
    List<CategoryTotal> sumSpendingByCategory(
        String username,
        LocalDate start,
        LocalDate end
    );

    // query here........... 
    // select COUNT(amount) columns with category (param), 
    // where between start/end dates - need to iterate through each date?
}
