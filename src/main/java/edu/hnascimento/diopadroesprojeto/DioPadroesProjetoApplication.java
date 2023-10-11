package edu.hnascimento.diopadroesprojeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DioPadroesProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioPadroesProjetoApplication.class, args);
	}

}
