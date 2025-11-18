package br.com.talentvision.controller;

import br.com.talentvision.model.User;
import br.com.talentvision.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // thymeleaf: register.html
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute User user) {
        service.register(user);
        return "redirect:/login";
    }
}
