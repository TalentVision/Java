package br.com.talentvision.controller;

import br.com.talentvision.model.dto.ResumeDTO;
import br.com.talentvision.service.message_queue.ResumeSender;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resumes")
public class ResumeController {
    private final ResumeSender producer;

    public ResumeController(ResumeSender producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<String> enviar(@RequestBody ResumeDTO dto) {
        producer.enviarCurriculo(dto);
        return ResponseEntity.ok("Currículo enviado para avaliação!");
    }
}
