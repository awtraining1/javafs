package com.ni.farm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"com.ni.config", "com.ni.farm.services","com.ni.farm.repositries", "com.ni.farm.controllers" })
@EnableJpaRepositories
@SpringBootApplication
public class FarmMgmtAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmMgmtAppApplication.class, args);
	}

    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
