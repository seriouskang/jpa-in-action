package com.example.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {
    @Id @GeneratedValue
    private Long id;
    private String name;

    public Employee(String name) {
        this.name = name;
    }
}
