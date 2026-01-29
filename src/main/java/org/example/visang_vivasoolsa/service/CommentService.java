package org.example.visang_vivasoolsa.service;

import lombok.RequiredArgsConstructor;

import org.example.visang_vivasoolsa.entity.Belief;
import org.example.visang_vivasoolsa.entity.Comment;
import org.example.visang_vivasoolsa.entity.Member;
import org.example.visang_vivasoolsa.repository.BeliefRepository;
import org.example.visang_vivasoolsa.repository.CommentRepository;
import org.example.visang_vivasoolsa.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BeliefRepository beliefRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void writeComment(Long memberId, Long beliefId, String content) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        Belief belief = beliefRepository.findById(beliefId).orElseThrow();

        Comment comment = new Comment();
        comment.setMember(member);
        comment.setBelief(belief);
        comment.setContent(content);

        commentRepository.save(comment);
    }

    public List<Comment> getComments(Long beliefId) {
        return commentRepository.findByBeliefIdOrderByCreatedAtDesc(beliefId);
    }
}
