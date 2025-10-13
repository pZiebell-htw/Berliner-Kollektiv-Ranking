package com.example.BerlinerKollektivRanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BerlinerKollektivRankingApplication {

	public static List<Kollektiv> kollektivList;
	public static List<Dj> djList;

	public static void main(String[] args) {
		SpringApplication.run(BerlinerKollektivRankingApplication.class, args);


	}
}
