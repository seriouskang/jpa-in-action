package com.example.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "COMPANY_ID")
    private List<Employee> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
