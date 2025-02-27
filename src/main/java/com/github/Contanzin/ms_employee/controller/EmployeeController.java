package com.github.Contanzin.ms_employee.controller;


import com.github.Contanzin.ms_employee.dto.EmployeeRequestDTO;
import com.github.Contanzin.ms_employee.dto.EmployeeResponseDTO;
import com.github.Contanzin.ms_employee.entity.Employee;
import com.github.Contanzin.ms_employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>>findAll(){
        List<EmployeeResponseDTO>dto = service.findAll();

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO>fidById(@PathVariable Long id){
        EmployeeResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO>insert(@RequestBody EmployeeRequestDTO requestDTO){
        EmployeeResponseDTO dto = service.insert(requestDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.id())
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO>update(@PathVariable Long id, @RequestBody EmployeeRequestDTO requestDTO){
        EmployeeResponseDTO dto = service.update(id, requestDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
