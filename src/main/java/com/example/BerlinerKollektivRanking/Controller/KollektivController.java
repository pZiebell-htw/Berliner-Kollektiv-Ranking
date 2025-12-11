package com.example.BerlinerKollektivRanking.Controller;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Service.KollektivService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KollektivController {

    private final KollektivService service;

    public KollektivController(KollektivService service) {
        this.service = service;
    }

    @GetMapping("/kollektivs")
    public List<Kollektiv> getAllKollektivs() {
        return service.getAll();
    }

    @GetMapping("/kollektivs/{id}")
    public Kollektiv getKollektivById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    @GetMapping("/rankedKollektivs")
    public List<Kollektiv> rankedKollektivs() {
        return service.getRanked();
    }

    @GetMapping("/sortedByGenreKollektivs")
    public List<Kollektiv> sortedByGenreKollektivs() {
        return service.getSortedByGenre();
    }

    @PostMapping("/kollektiv")
    public Kollektiv createKollektiv(@RequestBody Kollektiv kollektiv) {
        return service.save(kollektiv);
    }
}
