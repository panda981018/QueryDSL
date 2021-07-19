package com.example.querydsl.controller;

import com.example.querydsl.model.MemberEntity;
import com.example.querydsl.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 메인 페이지
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String showSignUp() {
        return "signup";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    // 회원가입 정보 받고 DB에 넣기
    @PostMapping("/user/join")
    public String join(@RequestParam(value = "username") String email, @RequestParam(value="password") String password) {

        // 현재 시간
        LocalDateTime now = LocalDateTime.now();
        // HH = 24시간 포맷, hh = 12시간 포맷
        String time = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        MemberEntity user = new MemberEntity(email, password, time);
        memberService.joinUs(user);

        return "redirect:/login";
    }

    // 로그인 정보처리
    @PostMapping("/user/login")
    public String login(
            @RequestParam(value = "username") String email,
            @RequestParam(value="password") String password,
            Model model) throws SQLException {

        MemberEntity user = memberService.getUser(email, password);

        model.addAttribute("userId", user.getId());
        model.addAttribute("userEmail", user.getEmail());
        model.addAttribute("userPassword", user.getPassword());
        model.addAttribute("userCreateDate", user.getCreateDate());

        return "loginSuccess";
    }

    @GetMapping("/error")
    public String error() {
        // 에러처리 어떻게 할지 고민해보기
        return "error";
    }
}
