package com.example.financial_backend.dto;



import com.example.financial_backend.model.enums.Role;
import com.example.financial_backend.model.enums.Status;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private Role role;
    private Status status;
}