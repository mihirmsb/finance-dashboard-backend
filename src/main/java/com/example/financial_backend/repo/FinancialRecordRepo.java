package com.example.financial_backend.repo;

import com.example.financial_backend.model.FinancialRecord;
import com.example.financial_backend.model.enums.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordRepo extends JpaRepository<FinancialRecord,Long> {

    List<FinancialRecord> findByType(RecordType type);
    List<FinancialRecord> findByCategory(String category);
    List<FinancialRecord> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
