package br.com.talentvision.service.message_queue;

import br.com.talentvision.config.QueueConfig;
import br.com.talentvision.model.dto.ResumeDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResumeSender {

    private final RabbitTemplate rabbitTemplate;

    public ResumeSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarCurriculo(ResumeDTO dto) {
        rabbitTemplate.convertAndSend(
                QueueConfig.FILA_CURRICULO_RECEBIDO, dto
        );
    }
}