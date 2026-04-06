package com.example.financial_backend.controller;


import com.example.financial_backend.model.FinancialRecord;
import com.example.financial_backend.model.enums.RecordType;
import com.example.financial_backend.service.FinancialRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService financialRecordService;

    @PostMapping
    public FinancialRecord createRecord(@Valid @RequestBody FinancialRecord financialRecord){
        return financialRecordService.createRecord(financialRecord);
    }

//    @GetMapping
//    public List<FinancialRecord> getAllRecords(){
//        return financialRecordService.getAllRecords();
//    }

    @GetMapping("/{id}")
    public FinancialRecord getRecordById(@PathVariable long id){
        return financialRecordService.getRecordById(id);
    }

    @GetMapping
    public List<FinancialRecord> getRecords(
            @RequestParam(required = false) RecordType type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate
    ) {
        LocalDate start = null;
        LocalDate end = null;

        if (startDate != null && endDate != null) {
            start = LocalDate.parse(startDate);
            end = LocalDate.parse(endDate);
        }

        return financialRecordService.getFilteredRecords(type, category, start, end);

    }

    @PutMapping("/{id}")
    public FinancialRecord updateRecord(@Valid @PathVariable long id, @RequestBody FinancialRecord updatedFinancialRecord){
        return financialRecordService.updateRecord(id, updatedFinancialRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteRecordById(@PathVariable long id){
        financialRecordService.deleteRecordById(id);
    }

}
