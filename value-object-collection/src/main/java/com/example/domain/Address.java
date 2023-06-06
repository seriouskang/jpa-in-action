package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

import static lombok.AccessLevel.*;

@Embeddable
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
