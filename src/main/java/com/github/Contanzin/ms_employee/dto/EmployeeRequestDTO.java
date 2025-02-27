package com.github.Contanzin.ms_employee.dto;

import java.time.LocalDate;

public record EmployeeRequestDTO(
        String nome,
        String cpf,
        String email,
        Double salary,
        LocalDate birthDate
) {
}
