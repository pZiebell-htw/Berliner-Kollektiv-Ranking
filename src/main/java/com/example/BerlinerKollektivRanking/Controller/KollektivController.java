package com.example.BerlinerKollektivRanking.Controller;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Service.KollektivService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class KollektivController {

    @GetMapping("/kollektivs")
    public List<Kollektiv> getAllKollektivs() {
        return KollektivService.kollektivList;
    }

    @GetMapping("/rankedKollektivs")
    public List<Kollektiv> rankedKollektivs() {
        KollektivService.kollektivList.sort(Comparator.comparing(Kollektiv::getDurchschnittsBewertung).reversed());
        return KollektivService.kollektivList;
    }

    @GetMapping("/sortedByGenreKollektivs")
    public List<Kollektiv> sortedByGenreKollektivs() {
        KollektivService.kollektivList.sort(Comparator.comparing(Kollektiv::getGenre));
        return KollektivService.kollektivList;
    }

}