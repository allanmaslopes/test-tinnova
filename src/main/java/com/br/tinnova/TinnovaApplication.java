package com.br.tinnova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients
@EnableSpringDataWebSupport
public class TinnovaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinnovaApplication.class, args);
	}

}
