package com.rk.crudservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.PrePersist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rk.crudservice.entity.DBObject;
import com.rk.crudservice.service.CrudOperationService;

@SpringBootApplication
@ComponentScan(basePackages="com.rk.crudservice")
@EnableJpaRepositories("com.rk.crudservice.repository")
public class CrudServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CrudOperationService userService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<DBObject>> typeReference = new TypeReference<List<DBObject>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
			try {
				List<DBObject> objects = mapper.readValue(inputStream, typeReference);
				userService.save(objects);
				System.out.println("Data loaded to H2 DB Successfully!");
			} catch (IOException e) {
				System.out.println("Unable to save Data: " + e.getMessage());
			}
		};
	}

}
