package com.example;

import com.example.domain.Address;
import com.example.domain.Member;
import com.example.infrastructure.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class BootApplicationTests {
    @Autowired
    private MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void persist() {
        Member member = new Member(new Address("서울", "여의공원로", "68"));
        member.addAddressHistory(new Address("서울", "효자로", "12"));
        member.addAddressHistory(new Address("제주", "공항로", "2"));

        memberRepository.save(member);
    }

    @Test
    @Transactional
    void find() {
        Member member = new Member(new Address("서울", "여의공원로", "68"));
        member.addAddressHistory(new Address("서울", "효자로", "12"));
        member.addAddressHistory(new Address("제주", "공항로", "2"));

        memberRepository.saveAndFlush(member);
        entityManager.clear();

        Optional<Member> foundMember = memberRepository.findById(member.getId());
        System.out.println("==============================");

        List<Address> addressHistory = foundMember.get().getAddressHistory();
        System.out.println("addressHistory = " + addressHistory);
    }

    @Test
    void update() {
        Member member = new Member(new Address("서울", "여의공원로", "68"));
        member.addAddressHistory(new Address("서울", "효자로", "12"));
        member.addAddressHistory(new Address("제주", "공항로", "2"));
        memberRepository.saveAndFlush(member);

        System.out.println("==============================");

        member.getAddressHistory().remove(new Address("제주", "공항로", "2"));
        member.getAddressHistory().add(new Address("판교", "분당내곡로", "131"));
        memberRepository.saveAndFlush(member);
    }
}
