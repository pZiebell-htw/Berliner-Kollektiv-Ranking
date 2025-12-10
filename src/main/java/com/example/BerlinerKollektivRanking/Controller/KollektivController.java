package com.example.BerlinerKollektivRanking.Controller;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Service.KollektivService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class KollektivController {

    @Autowired
    private KollektivService service;

    @GetMapping("/kollektivs")
    public List<Kollektiv> getAllKollektivs() {
        return service.getAll();
    }

    @GetMapping("/kollektivs/{id}")
    public Kollektiv getKollektivById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/rankedKollektivs")
    public List<Kollektiv> rankedKollektivs() {
        List<Kollektiv> list = service.getAll();
        list.sort(Comparator.comparing(Kollektiv::getDurchschnittsBewertung).reversed());
        return list;
    }

    @GetMapping("/sortedByGenreKollektivs")
    public List<Kollektiv> sortedByGenreKollektivs() {
        List<Kollektiv> list = service.getAll();
        list.sort(Comparator.comparing(Kollektiv::getGenre));
        return list;
    }

    @PostMapping("/kollektiv")
    public Kollektiv createKollektiv(@RequestBody Kollektiv kollektiv) {
        return service.save(kollektiv);
    }
}
