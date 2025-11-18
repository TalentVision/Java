package br.com.talentvision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivateController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/private/home")
    public String home() {
        return "home";
    }
}

