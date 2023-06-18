package com.example.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id @GeneratedValue
    private Long id;
    @ManyToMany
    @JoinTable(name = "ORDER_ITEM")
    private List<Item> items = new ArrayList<>();
}
