package org.example.visang_vivasoolsa.repository;

import org.example.visang_vivasoolsa.entity.DailyLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyLogRepository extends JpaRepository<DailyLog, Long> {
    List<DailyLog> findByMemberIdOrderByCreatedAtDesc(Long memberId);
}
