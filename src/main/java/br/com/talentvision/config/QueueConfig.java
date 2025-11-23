package br.com.talentvision.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QueueConfig {

    public static final String FILA_CURRICULO_RECEBIDO = "curriculo.recebido";
    public static final String FILA_CURRICULO_AVALIADO = "curriculo.avaliado";
    public static final String FILA_NOTIFICACAO_USUARIO = "curriculo.notificar";

    @Bean
    public Queue filaCurriculoRecebido() {
        return new Queue(FILA_CURRICULO_RECEBIDO, true);
    }

    @Bean
    public Queue filaCurriculoAvaliado() {
        return new Queue(FILA_CURRICULO_AVALIADO, true);
    }

    @Bean
    public Queue filaNotificacaoUsuario() {
        return new Queue(FILA_NOTIFICACAO_USUARIO, true);
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

}
