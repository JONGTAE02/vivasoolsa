package org.example.visang_vivasoolsa.repository;

import org.example.visang_vivasoolsa.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBeliefIdOrderByCreatedAtDesc(Long beliefId);
}
