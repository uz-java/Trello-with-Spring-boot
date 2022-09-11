package com.example.trello_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TrelloSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(TrelloSpringBootApplication.class, args);
	}
}
