package com.aidyn.financetracker.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aidyn.financetracker.dto.CategoryTotal;
import com.aidyn.financetracker.entities.Transaction;

// cool Spring Boot JPA connector!!
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // preface with custom query since it's too complex to express through method name

    // get category and sum the amounts spent in that category
    // make sure the date cell falls in between the date range provided. 
    // group the results by category. one category -> multiple #'s put together
    // then order those results by sum (larger to smaller)
    @Query("""
        select new com.aidyn.financetracker.dto.CategoryTotal(t.category, sum(t.amount))
        from Transaction t
        where t.username = :username
            and t.date >= :start
            and t.date < :end
        group by t.category
        order by sum(t.amount) desc
        """)

    // Spring data JPA can automatically create queries based on the method names u declare in ur repository interface 
    // (that feature is not used for this query since keywords are too specific)
    
    // find all category totals that are within the date range (start, end) and have been created by user (username) 
    List<CategoryTotal> sumSpendingByCategory(
        @Param("username") String username, 
        @Param("start") LocalDate start, 
        @Param("end") LocalDate end
    );

    
}
