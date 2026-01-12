package com.aidyn.financetracker.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aidyn.financetracker.dto.CategoryTotal;
import com.aidyn.financetracker.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

        List<CategoryTotal> sumSpendingByCategory(
        String username,
        LocalDate start,
        LocalDate end
    );
}
