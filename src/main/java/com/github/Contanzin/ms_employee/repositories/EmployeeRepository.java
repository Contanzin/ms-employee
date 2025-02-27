package com.github.Contanzin.ms_employee.repositories;

import com.github.Contanzin.ms_employee.entity.Employee;
import com.github.Contanzin.ms_employee.service.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
