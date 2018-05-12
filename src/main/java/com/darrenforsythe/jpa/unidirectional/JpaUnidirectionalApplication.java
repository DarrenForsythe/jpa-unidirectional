package com.darrenforsythe.jpa.unidirectional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaUnidirectionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaUnidirectionalApplication.class, args);
	}
}
