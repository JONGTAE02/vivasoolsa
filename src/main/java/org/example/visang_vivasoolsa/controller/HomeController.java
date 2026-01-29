package org.example.visang_vivasoolsa.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.visang_vivasoolsa.entity.Member;
import org.example.visang_vivasoolsa.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @PostMapping("/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("department") String department,
                        HttpSession session) {

        Member member = memberService.login(name, department);
        session.setAttribute("memberId", member.getId());

        return "redirect:/intro";
    }

    @GetMapping("/intro")
    public String intro() {
        return "intro";
    }
}
