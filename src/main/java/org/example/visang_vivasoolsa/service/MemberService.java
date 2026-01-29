package org.example.visang_vivasoolsa.service;

import lombok.RequiredArgsConstructor;
import org.example.visang_vivasoolsa.entity.Member;
import org.example.visang_vivasoolsa.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member login(String name, String department) {
        Optional<Member> member = memberRepository.findByName(name);
        if (member.isPresent()) {
            return member.get();
        }else {
            Member newMember = new Member(name, department);
            return memberRepository.save(newMember);
        }
    }

}
