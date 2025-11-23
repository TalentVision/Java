package br.com.talentvision.controller;

import br.com.talentvision.model.dto.ResumeDTO;
import br.com.talentvision.service.message_queue.ResumeSender;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/resume")
public class ResumeController {
    private final ResumeSender producer;

    public ResumeController(ResumeSender producer) {
        this.producer = producer;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("resume", new ResumeDTO());
        return "resume";
    }

    @PostMapping("/send")
    public String submitResume(@ModelAttribute("resume") ResumeDTO resumeDTO,
                               RedirectAttributes redirectAttributes) {

        producer.enviarCurriculo(resumeDTO);

        redirectAttributes.addFlashAttribute("message", "Currículo enviado com sucesso!");
        return "redirect:/resume/form";
    }
}
