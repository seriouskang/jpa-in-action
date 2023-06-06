package com.example;

import com.example.domain.AddressEntity;
import com.example.domain.Member;
import com.example.infrastructure.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootApplicationTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void update() {
        Member member = new Member();
        member.addAddressHistory(new AddressEntity("서울", "효자로", "12"));
        member.addAddressHistory(new AddressEntity("제주", "공항로", "2"));
        memberRepository.save(member);

        System.out.println("========================================");

        member.removeAddressHistory(new AddressEntity("제주", "공항로", "2"));
        member.addAddressHistory(new AddressEntity("판교", "분당내곡로", "131"));
        memberRepository.save(member);
    }
}
