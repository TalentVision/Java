package br.com.talentvision.service.message_queue;

import br.com.talentvision.config.QueueConfig;
import br.com.talentvision.model.dto.ApplicationDecisionDTO;
import br.com.talentvision.model.dto.EvaluationResultDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class JobConsumer {
    private final RabbitTemplate rabbitTemplate;

    public JobConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = QueueConfig.FILA_CURRICULO_AVALIADO)
    public void decidir(EvaluationResultDTO avaliacao) {

        System.out.println("Empresa analisando candidato: " + avaliacao.getIdUser());

        //TODO Ajustar metodo de avaliação coerente com o negocio
        //Teste
        boolean accepted = false;
        try {
            Thread.sleep(5000);
            accepted = true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ApplicationDecisionDTO decision = new ApplicationDecisionDTO();
        decision.setIdUser(avaliacao.getIdUser());
        decision.setDecision(accepted);
        decision.setMessage(accepted ? "Parabéns! Seu currículo foi aceito." : "Obrigado, mas seguimos com outros candidatos.");

        rabbitTemplate.convertAndSend(
                QueueConfig.FILA_NOTIFICACAO_USUARIO,
                decision
        );
    }
}
