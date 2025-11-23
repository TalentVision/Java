package br.com.talentvision;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class TalentVisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentVisionApplication.class, args);
	}

}
