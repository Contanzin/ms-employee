package com.github.Contanzin.ms_employee.dto;

import com.github.Contanzin.ms_employee.entity.Employee;

import java.time.LocalDate;

public record EmployeeResponseDTO(
        Long id,
        String nome,
        String email,
        String cpf,
        double salary,
        LocalDate birthDate) {

    public EmployeeResponseDTO(Employee entity){
        this(entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getCpf(),
                entity.getSalary(),
                entity.getBirthDate());
    }
}
