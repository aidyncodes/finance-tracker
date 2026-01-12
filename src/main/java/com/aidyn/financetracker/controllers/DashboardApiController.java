package com.aidyn.financetracker.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aidyn.financetracker.responses.PieChartResponse;
import com.aidyn.financetracker.services.DashboardService;

@RestController
@RequestMapping("/api/dashboard") // NOTE:

public class DashboardApiController {

    private final DashboardService dashboardService;

    public DashboardApiController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/spend-by-category") // api endpoint link
    public PieChartResponse spendByCategory(
        @RequestParam(defaultValue = "month") String range, 
        Principal principal
    ) {
        return dashboardService.getSpendByCategoryForRange(
            principal.getName(), 
            range
        );
    }
}
