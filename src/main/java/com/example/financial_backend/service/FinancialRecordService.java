package com.example.financial_backend.service;

import com.example.financial_backend.model.FinancialRecord;
import com.example.financial_backend.repo.FinancialRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepo financialRecordRepo;

    public FinancialRecord createRecord(FinancialRecord financialRecord){
        return financialRecordRepo.save(financialRecord);
    }

    public List<FinancialRecord> getAllRecords(){
        return financialRecordRepo.findAll();
    }

    public FinancialRecord getRecordById(long id){
        return financialRecordRepo.findById(id).orElse(null);
    }

    public FinancialRecord updateRecord(long id, FinancialRecord updatedFinancialRecord){
        FinancialRecord financialRecord = financialRecordRepo.findById(id).orElse(null);
        if(financialRecord != null){
            financialRecord.setAmount(updatedFinancialRecord.getAmount());
            financialRecord.setType(updatedFinancialRecord.getType());
            financialRecord.setCategory(updatedFinancialRecord.getCategory());
            financialRecord.setDate(updatedFinancialRecord.getDate());
            financialRecord.setNotes(updatedFinancialRecord.getNotes());
            return financialRecordRepo.save(financialRecord);
        }
        return null;
    }

    public void deleteRecordById(long id){
        financialRecordRepo.deleteById(id);
    }

}
