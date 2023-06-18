package com.example.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Employee {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    public Employee(String name, Company company) {
        this.name = name;
        this.company = company;
    }
}
