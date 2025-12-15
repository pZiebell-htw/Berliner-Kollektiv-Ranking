package com.example.BerlinerKollektivRanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class BerlinerKollektivRankingApplication {

	@GetMapping("/startpage")
	public static void main(String[] args) {

		SpringApplication.run(BerlinerKollektivRankingApplication.class, args);

	}
}
