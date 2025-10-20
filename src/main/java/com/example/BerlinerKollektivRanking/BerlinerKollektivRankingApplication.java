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

	Kollektiv hakkeBerlin = new Kollektiv("HakkeBerlin", Kollektiv.Genre.Gabber);
	Kollektiv pfandidos = new Kollektiv("Pfandidos", Kollektiv.Genre.Trance);
	Kollektiv f90 = new Kollektiv("Formula90", Kollektiv.Genre.Trance);
	Kollektiv passivAggresiv = new Kollektiv("PassivAggresiv", Kollektiv.Genre.Gabber);
	Kollektiv goatball = new Kollektiv("Goatball", Kollektiv.Genre.Trance);
	Kollektiv polyamor  = new Kollektiv("Polyamor", Kollektiv.Genre.Groove);

	Dj bitschuBatschu = new Dj("BitschuBatschu", "Trance");


	@GetMapping("/startpage")
	public static void main(String[] args) {

		SpringApplication.run(BerlinerKollektivRankingApplication.class, args);

	}
}
