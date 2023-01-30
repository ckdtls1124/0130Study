package org.spring.security2.controller;

import lombok.RequiredArgsConstructor;
import org.spring.security2.dto.MemberDto;
import org.spring.security2.repository.MembersRepository;
import org.spring.security2.service.MemberServ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberControl {

    private final MemberServ memberServ;


//    JOIN process ==========================================

    @GetMapping("/join")
    public String join(Model model){
        model.addAttribute("memberDto", new MemberDto());
        return "member/joinP";
    }

    @PostMapping("/joinDo")
    public String joinpost(@Valid MemberDto memberDto, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/member/join";
        }
        memberServ.insert(memberDto);
        return "redirect:/member/login";
    }

//    ========================================================

//    Login ==================================================

    @GetMapping("/login")
    public String loginP(){

        return "/member/loginP";
    }

    @GetMapping("/loginDo")
    public String loginDo(){

        return "/index";
    }


//    ========================================================
//    Roles ==================================================
    @GetMapping("/admin")
    public String admin(){
        return "/member/admin";
    }

    @GetMapping("/manager")
    public String manager(){
        return "/member/manager";
    }



}
