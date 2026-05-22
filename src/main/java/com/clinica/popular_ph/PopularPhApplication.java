package com.clinica.popular_ph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class PopularPhApplication {
	public static void main(String[] args) {
		SpringApplication.run(PopularPhApplication.class, args);
	}

}
