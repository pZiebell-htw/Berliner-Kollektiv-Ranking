package com.example.BerlinerKollektivRanking;

import com.example.BerlinerKollektivRanking.Controller.DjController;
import com.example.BerlinerKollektivRanking.Controller.KollektivController;
import com.example.BerlinerKollektivRanking.Model.Dj;
import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BerlinerKollektivRankingApplication {

	@GetMapping("/startpage")
	public static void main(String[] args) {

		SpringApplication.run(BerlinerKollektivRankingApplication.class, args);

	}
}
