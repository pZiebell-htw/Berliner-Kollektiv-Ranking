package com.example.BerlinerKollektivRanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BerlinerKollektivRankingApplication {

	public static List<Kollektiv> kollektivList = new ArrayList<>();
	public static List<Dj> djList = new ArrayList<>();

	Kollektiv hakkeBerlin = new Kollektiv("HakkeBerlin", "Gabber/Hardcore",0.0);
	Kollektiv pfandidos = new Kollektiv("Pfandidos", "Trance/Gabber",0.0);
	Kollektiv f90 = new Kollektiv("Formula90", "Trance",3.9);
	Dj bitschuBatschu = new Dj("BitschuBatschu", "Trance");

	@GetMapping("/startpage")
	public static void main(String[] args) {
		SpringApplication.run(BerlinerKollektivRankingApplication.class, args);

		DjController djController = new DjController();
		KollektivController kollektivController = new KollektivController();

		djController.getAllDJs();
		kollektivController.getAllKollektivs();

	}
}
