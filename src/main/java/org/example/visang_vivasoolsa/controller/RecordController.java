package org.example.visang_vivasoolsa.controller;

import lombok.RequiredArgsConstructor;
import org.example.visang_vivasoolsa.entity.DailyLog;
import org.example.visang_vivasoolsa.entity.Member;
import org.example.visang_vivasoolsa.service.DailyLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecordController {

    private final DailyLogService dailyLogService;

    @GetMapping("/record/list")
    public String recordList(
            @SessionAttribute(name = "loginMember", required = false) Member loginMember,
            Model model) {
        if (loginMember == null) {
            return "redirect:/";
        }
        List<DailyLog> myLogs = dailyLogService.findLogsByMember(loginMember.getId());
        model.addAttribute("logs", myLogs);

        return "record_list";
    }
}