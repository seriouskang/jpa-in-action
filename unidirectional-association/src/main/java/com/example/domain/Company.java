package com.example.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Company {
    @Id @GeneratedValue
    private Long id;
    private String name;

    public Company(String name) {
        this.name = name;
    }
}
