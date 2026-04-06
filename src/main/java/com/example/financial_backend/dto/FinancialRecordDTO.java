package com.example.financial_backend.dto;

import com.example.financial_backend.model.enums.RecordType;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinancialRecordDTO {

    private Long id;
    private Double amount;
    private RecordType type;
    private String category;
    private LocalDate date;
    private String notes;

    private Long userId;
}
