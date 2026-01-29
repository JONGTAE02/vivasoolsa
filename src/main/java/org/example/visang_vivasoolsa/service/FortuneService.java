package org.example.visang_vivasoolsa.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.example.visang_vivasoolsa.entity.DailyLog;
import org.example.visang_vivasoolsa.entity.Fortune;
import org.example.visang_vivasoolsa.entity.Member;
import org.example.visang_vivasoolsa.repository.DailyLogRepository;
import org.example.visang_vivasoolsa.repository.FortuneRepository;
import org.example.visang_vivasoolsa.repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class FortuneService {
    private final FortuneRepository fortuneRepository;
    private final MemberRepository memberRepository;
    private final DailyLogRepository dailyLogRepository;
    private final Random random = new Random();

    @Transactional
    public Fortune drawFortune(Long memberId) {
        // 1~7번 믿음 중 하나 랜덤 선택
        long randomBeliefId = random.nextLong(7) + 1;

        // 해당 믿음의 운세 5개 가져오기
        List<Fortune> fortuneCandidates = fortuneRepository.findByBeliefId(randomBeliefId);

        // 5개 중 하나 랜덤 뽑기
        Collections.shuffle(fortuneCandidates);
        Fortune selectedFortune = fortuneCandidates.get(0);

        // 기록 저장
        Member member = memberRepository.findById(memberId).orElseThrow();
        DailyLog log = new DailyLog();
        log.setMember(member);
        log.setFortune(selectedFortune);
        log.setIsGolden(false);
        dailyLogRepository.save(log);

        return selectedFortune;
    }
    public Fortune getFortune(Long id) {
        return fortuneRepository.findById(id).orElseThrow();
    }
}
