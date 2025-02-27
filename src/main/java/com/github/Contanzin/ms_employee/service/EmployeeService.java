package com.github.Contanzin.ms_employee.service;

import com.github.Contanzin.ms_employee.dto.EmployeeRequestDTO;
import com.github.Contanzin.ms_employee.dto.EmployeeResponseDTO;
import com.github.Contanzin.ms_employee.entity.Employee;
import com.github.Contanzin.ms_employee.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public List<EmployeeResponseDTO> findAll() {
        List<Employee> list = repository.findAll();
        return list.stream().map(EmployeeResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public EmployeeResponseDTO findById(Long id) {
        Employee entity = repository.findById(id).orElseThrow(
        () -> new EntityNotFoundException("Recurso não Encontrado. Id: " + id)
    );
        return new EmployeeResponseDTO(entity);
    }

    @Transactional
    public EmployeeResponseDTO insert(EmployeeRequestDTO requestDTO){
        Employee entity = new Employee();
        toEntity(requestDTO, entity);
        entity = repository.save(entity);
        return new EmployeeResponseDTO(entity);
    }

    private void toEntity(EmployeeRequestDTO requestDTO, Employee entity){
        entity.setNome(requestDTO.nome());
        entity.setCpf(requestDTO.cpf());
        entity.setEmail(requestDTO.email());
        entity.setSalary(requestDTO.salary());
        entity.setBirthDate(requestDTO.birthDate());
    }

    @Transactional
    public EmployeeResponseDTO update(Long id, EmployeeRequestDTO requestDTO){
        try{
            Employee entity = repository.getReferenceById(id);
            toEntity(requestDTO, entity);
            entity = repository.save(entity);
            return new EmployeeResponseDTO(entity);
        }catch (EntityNotFoundException ex){
            throw new EntityNotFoundException("Recurso não Encontrado. Id: " + id);
        }
    }

    @Transactional
    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("Recurso não encontrado. Id: "+ id);
        }
        repository.deleteById(id);
    }
}
