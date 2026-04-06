package com.example.financial_backend.service;

import com.example.financial_backend.dto.FinancialRecordDTO;
import com.example.financial_backend.model.FinancialRecord;
import com.example.financial_backend.model.User;
import com.example.financial_backend.model.enums.RecordType;
import com.example.financial_backend.repo.FinancialRecordRepo;
import com.example.financial_backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepo financialRecordRepo;

    @Autowired
    private UserRepo userRepo;

    public FinancialRecord createRecord(FinancialRecord financialRecord){
        return financialRecordRepo.save(financialRecord);
    }

    public List<FinancialRecord> getAllRecords(){
        return financialRecordRepo.findAll();
    }

    public FinancialRecord getRecordById(long id){
        return financialRecordRepo.findById(id).orElse(null);
    }

    public List<FinancialRecord> getFilteredRecords(RecordType type, String category, LocalDate startDate, LocalDate endDate){
        if(type!=null){
            return financialRecordRepo.findByType(type);
        }
        if(category!=null){
            return financialRecordRepo.findByCategory(category);
        }
        if(startDate!=null && endDate!=null){
            return financialRecordRepo.findByDateBetween(startDate,endDate);
        }
        return financialRecordRepo.findAll();
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
        throw new RuntimeException("Record not found");
    }

    public void deleteRecordById(long id){
        financialRecordRepo.deleteById(id);
    }

//    public FinancialRecord convertToEntity(FinancialRecordDTO dto) {
//
//        FinancialRecord record = new FinancialRecord();
//
//        record.setId(dto.getId());
//        record.setAmount(dto.getAmount());
//        record.setType(dto.getType());
//        record.setCategory(dto.getCategory());
//        record.setDate(dto.getDate());
//        record.setNotes(dto.getNotes());
//
//        User user = userRepo.findById(dto.getUserId())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        record.setCreatedBy(user);
//
//        return record;
//    }
//
//    public FinancialRecordDTO convertToDTO(FinancialRecord record) {
//
//        return FinancialRecordDTO.builder()
//                .id(record.getId())
//                .amount(record.getAmount())
//                .type(record.getType())
//                .category(record.getCategory())
//                .date(record.getDate())
//                .notes(record.getNotes())
//                .userId(record.getCreatedBy().getId())
//                .build();
//    }
}
