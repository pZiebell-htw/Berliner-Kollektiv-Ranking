package com.example.BerlinerKollektivRanking.Controller;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Service.KollektivService;
import org.springframework.web.bind.annotation.*;


import java.util.Comparator;
import java.util.List;


@RestController
@RequestMapping("/api")
public class KollektivController {

    @GetMapping("/kollektivs")
    public List<Kollektiv> getAllKollektivs() {
        return KollektivService.kollektivList;
    }

    @GetMapping("/kollektivs/{id}")
    public Kollektiv getKollektivById(@PathVariable String id) {
        return KollektivService.kollektivList.stream()
                .filter(k -> k.getId().equals(id))
                .findFirst()
                .orElse(null);
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

    @PostMapping("/kollektiv")
    public Kollektiv createKollektiv(@RequestBody Kollektiv kollektiv) {
        KollektivService.kollektivList.add(kollektiv);
        return kollektiv;
    }
}
