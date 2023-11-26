package com.rota.menor.custo.dijikstra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class DijikstraApplication {

	public static void main(String[] args) {
		SpringApplication.run(DijikstraApplication.class, args);
	}

}
