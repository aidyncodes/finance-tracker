package com.aidyn.financetracker.services;

import java.time.LocalDate;
//import org.springframework.stereotype.Service;

import com.aidyn.financetracker.repository.TransactionRepository;
import com.aidyn.financetracker.responses.PieChartResponse;

public class DashboardService {

    private final TransactionRepository transactionRepository;

    public DashboardService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public PieChartResponse getSpendByCategoryForRange(String username, String range) {
        LocalDate today = LocalDate.now();

        LocalDate start = switch (range) { // switch requires default
            case "week" -> today.with(java.time.DayOfWeek.MONDAY);
            case "year" -> today.withDayOfYear(1);
            default -> today.withDayOfMonth(1);
        };

        LocalDate end = today.plusDays(1); // note:

        var rows = transactionRepository.sumSpendingByCategory(username, start, end); // in TransactionRepository

        return new PieChartResponse( // PieChartResponse object takes lists
            rows.stream().map(r -> r.category()).toList(), // stream() connected to TransactionRepository
            rows.stream().map(r -> r.total().doubleValue()).toList()
        );
    }

}
