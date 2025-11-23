package br.com.talentvision.service.message_queue;

import br.com.talentvision.config.QueueConfig;
import br.com.talentvision.model.dto.EvaluationResultDTO;
import br.com.talentvision.model.dto.ResumeDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.talentvision.model.ResultStatus.WAITING_RESPONSE;

@Service
public class ResumeProcessorConsumer {

    private final RabbitTemplate rabbitTemplate;

    public ResumeProcessorConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = QueueConfig.FILA_CURRICULO_RECEBIDO)
    public void processar(ResumeDTO curriculo) {

        System.out.println("Processando currículo de: " + curriculo.getName());

        //TODO Sistema de Score coerente com a aplicação
        double score = Math.random() * 100;

        EvaluationResultDTO resultado = new EvaluationResultDTO();
        resultado.setIdUser(curriculo.getIdUser());
        resultado.setApplicationDescription(curriculo.getApplicationDescription());
        resultado.setScore(score);
        resultado.setStatus(WAITING_RESPONSE);


        rabbitTemplate.convertAndSend(
                QueueConfig.FILA_CURRICULO_AVALIADO,
                resultado
        );
    }
}
