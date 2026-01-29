package org.example.visang_vivasoolsa.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.visang_vivasoolsa.entity.Comment;
import org.example.visang_vivasoolsa.entity.Fortune;
import org.example.visang_vivasoolsa.service.CommentService;
import org.example.visang_vivasoolsa.service.FortuneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FortuneController {

    private final CommentService commentService;
    private final FortuneService fortuneService;

    @PostMapping("/fortune/draw")
    public String drawFortune(HttpSession session) {
        Long memberId = (Long) session.getAttribute("memberId");
        if (memberId == null) {
            return "redirect:/";
        }

        try {
            Fortune fortune = fortuneService.drawFortune(memberId);
            session.setAttribute("lastFortuneId", fortune.getId());

            return "redirect:/fortune/result";

        } catch (Exception e) {
            e.printStackTrace();
            session.invalidate();
            return "redirect:/";
        }
    }

    @GetMapping("/fortune/result")
    public String showResult(HttpSession session, Model model) {
        Long memberId = (Long) session.getAttribute("memberId");
        Long fortuneId = (Long) session.getAttribute("lastFortuneId");

        if (memberId == null || fortuneId == null) return "redirect:/";

        try {
            // 운세 가져오기
            Fortune fortune = fortuneService.getFortune(fortuneId);
            List<Comment> comments = commentService.getComments(fortune.getBelief().getId());

            model.addAttribute("comments", comments);
            model.addAttribute("fortune", fortune);
            return "result";

        } catch (Exception e) {
            return "redirect:/";
        }
    }

    @PostMapping("/fortune/comment")
    public String writeComment(@RequestParam("beliefId") Long beliefId,
                               @RequestParam("content") String content,
                               HttpSession session) {
        Long memberId = (Long) session.getAttribute("memberId");
        commentService.writeComment(memberId, beliefId, content);

        return "redirect:/fortune/result";
    }
}