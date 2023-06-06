package com.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Getter
@Entity
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue
    private Long id;
    @OneToMany(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    public void addAddressHistory(AddressEntity addressEntity) {
        addressHistory.add(addressEntity);
    }

    public void removeAddressHistory(AddressEntity addressEntity) {
        addressHistory.remove(addressEntity);
    }
}
