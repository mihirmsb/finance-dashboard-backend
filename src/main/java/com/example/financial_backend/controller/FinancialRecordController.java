package com.example.financial_backend.controller;


import com.example.financial_backend.model.FinancialRecord;
import com.example.financial_backend.service.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService financialRecordService;

    @PostMapping
    public FinancialRecord createRecord(@RequestBody FinancialRecord financialRecord){
        return financialRecordService.createRecord(financialRecord);
    }

    @GetMapping
    public List<FinancialRecord> getAllRecords(){
        return financialRecordService.getAllRecords();
    }

    @GetMapping("/{id}")
    public FinancialRecord getRecordById(@PathVariable long id){
        return financialRecordService.getRecordById(id);
    }

    @PutMapping("/{id}")
    public FinancialRecord updateRecord(@PathVariable long id, @RequestBody FinancialRecord updatedFinancialRecord){
        return financialRecordService.updateRecord(id, updatedFinancialRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteRecordById(@PathVariable long id){
        financialRecordService.deleteRecordById(id);
    }

}
