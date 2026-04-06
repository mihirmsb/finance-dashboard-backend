package com.example.financial_backend.controller;

import com.example.financial_backend.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/summary")
    public Map<String, Double> getSummary(){
        return dashboardService.getSummary();
    }

    @GetMapping("/category")
    public Map<String,Double> getCategoryWiseTotals(){
        return dashboardService.getCategoryWiseTotals();
    }
}
