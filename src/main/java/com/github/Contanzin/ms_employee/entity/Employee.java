package com.github.Contanzin.ms_employee.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table (name = "tb_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private Double salary;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    public Employee() {
    }

    public Employee(Long id, String nome, String cpf, String email, Double salary, LocalDate birthDate) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
