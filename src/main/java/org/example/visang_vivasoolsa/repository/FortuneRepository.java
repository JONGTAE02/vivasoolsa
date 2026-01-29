
package org.example.visang_vivasoolsa.repository;

import org.example.visang_vivasoolsa.entity.Fortune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FortuneRepository extends JpaRepository<Fortune, Long> {
    List<Fortune> findByBeliefId(Long beliefId);
}
