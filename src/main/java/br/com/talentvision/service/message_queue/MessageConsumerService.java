package br.com.talentvision.service.message_queue;

import br.com.talentvision.config.QueueConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

    @RabbitListener(queues = QueueConfig.FILA_NOTIFICACAO_USUARIO)
    public void receberMensagem(String mensagem) {
        System.out.println("Recebido: " + mensagem);

    }
}
