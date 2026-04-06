package com.example.financial_backend.service;

import com.example.financial_backend.model.FinancialRecord;
import com.example.financial_backend.model.enums.RecordType;
import com.example.financial_backend.repo.FinancialRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private FinancialRecordRepo financialRecordRepo;

    //Loop through all records
    //Add income
    //Add expense
    //Calculate balance
    public Map<String, Double> getSummary(){
        List<FinancialRecord> financialRecords = financialRecordRepo.findAll();
        double totalIncome=0.0;
        double totalExpense=0.0;

        for(FinancialRecord financialRecord:financialRecords){
            if(financialRecord.getType().equals(RecordType.INCOME)){
                totalIncome += financialRecord.getAmount();
            }
            else{
                totalExpense += financialRecord.getAmount();
            }
        }
        double netBalance=totalIncome-totalExpense;
        Map<String, Double> summary = new HashMap<>();
        summary.put("Net Balance", netBalance);
        summary.put("Total Income", totalIncome);
        summary.put("Total Expense", totalExpense);
        return summary;
    }

    public Map<String,Double> getCategoryWiseTotals(){
        List<FinancialRecord> financialRecords = financialRecordRepo.findAll();
        Map<String,Double> categoryMap = new HashMap<>();

        for(FinancialRecord financialRecord:financialRecords){
            String category = financialRecord.getCategory();
            double amount = financialRecord.getAmount();
            categoryMap.put(category, categoryMap.getOrDefault(category,0.0)+amount);
        }
        return categoryMap;
    }
}
