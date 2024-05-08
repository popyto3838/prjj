package com.prjj.controller;

import com.prjj.domain.Member;
import com.prjj.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {
    private final MemberService service;


    @GetMapping("signup")
    public String signupForm(Model model) {

        return "member/signup";
    }

    @PostMapping("signup")
    public String signup(Member member) {
        System.out.println(member);
        service.signup(member);
        return "redirect:/";
    }

    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("MemberList", service.list());

        return "member/list";
    }

    @GetMapping("")
    public String info(Integer id, Model model) {

        model.addAttribute("member", service.get(id));
        return "member/info";
    }

    @PostMapping("remove")
    public String remove(Integer id) {

        service.remove(id);
        return "redirect:/member/signup";
    }

    @GetMapping("modify")
    public String modifyForm(Integer id, Model model) {
        model.addAttribute("member", service.get(id));
        System.out.println(service.get(id));
        return "member/modify";
    }

    @PostMapping("modify")
    public String modify(Member member, RedirectAttributes rttr) {
        service.modify(member);

        rttr.addAttribute("id", member.getId());
        return "redirect:/member";
    }

    @GetMapping("email")
    @ResponseBody
    public String emailCheck(String email) {

        String message = service.emailCheck(email);

        return message;
    }
}
