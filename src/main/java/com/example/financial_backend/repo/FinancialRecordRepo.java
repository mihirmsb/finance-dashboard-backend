package com.example.financial_backend.repo;

import com.example.financial_backend.model.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRecordRepo extends JpaRepository<FinancialRecord,Long> {
}
