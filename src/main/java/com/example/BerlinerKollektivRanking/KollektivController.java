package com.example.BerlinerKollektivRanking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.BerlinerKollektivRanking.BerlinerKollektivRankingApplication;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class KollektivController {

    @GetMapping("/kollektivs")
    public String getAllKollektivs() {
        String allKollektivs = "";
        StringBuilder result = new StringBuilder();
        for (Kollektiv kollektiv : BerlinerKollektivRankingApplication.kollektivList) {
            allKollektivs = allKollektivs + kollektiv.getName() + " " + kollektiv.getGenre() + " " + kollektiv.getResidentClub() + "\n";
        }
        return allKollektivs;
    }

    @GetMapping("/rankedKollektivs")
    public String rankedKollektivs() {
        String rankedKollektivs = "";
        BerlinerKollektivRankingApplication.kollektivList.sort(Comparator.comparing(Kollektiv::getDurchschnittsBewertung).reversed());
        for (Kollektiv kollektiv : BerlinerKollektivRankingApplication.kollektivList) {
            rankedKollektivs = rankedKollektivs + kollektiv.getName() + " " + kollektiv.getGenre() + " " + kollektiv.getResidentClub() + " " + kollektiv.getDurchschnittsBewertung() + "<br>";
        }
        return rankedKollektivs;
    }
}