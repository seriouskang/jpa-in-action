package com.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.*;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Member {
    @Id @GeneratedValue
    private Long id;
    @Embedded
    private Address currentAddress;
    @ElementCollection
    @CollectionTable(name = "ADDRESS_HISTORY", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();

    public Member(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public void addAddressHistory(Address address) {
        this.addressHistory.add(address);
    }
}
