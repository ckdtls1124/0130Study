package org.spring.security2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/index", "/"})
    public String index(Model model){
        model.addAttribute("text1", "INDEX");
        return "index";
    }
}
