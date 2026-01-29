package org.example.visang_vivasoolsa.service;

import lombok.RequiredArgsConstructor;
import org.example.visang_vivasoolsa.entity.DailyLog;
import org.example.visang_vivasoolsa.repository.DailyLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DailyLogService {

    private final DailyLogRepository dailyLogRepository;

    /**
     * 특정 회원의 소감 기록 전체 조회 (최신순)
     */
    public List<DailyLog> findLogsByMember(Long memberId) {
        return dailyLogRepository.findByMemberIdOrderByCreatedAtDesc(memberId);
    }

    // 소감 저장하는 메서드가 추가 예정

    @Transactional
    public Long saveDailyLog(DailyLog dailyLog) {
        dailyLogRepository.save(dailyLog);
        return dailyLog.getId();
    }
}