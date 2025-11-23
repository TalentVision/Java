package br.com.talentvision.service.message_queue;

import br.com.talentvision.config.QueueConfig;
import br.com.talentvision.model.dto.ApplicationDecisionDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationConsumer {

    @RabbitListener(queues = QueueConfig.FILA_NOTIFICACAO_USUARIO)
    public void notificar(ApplicationDecisionDTO notificacao) {
        System.out.println("Notificando usuário " + notificacao.getIdUser());
        System.out.println("Mensagem: " + notificacao.getMessage());
    }
}
