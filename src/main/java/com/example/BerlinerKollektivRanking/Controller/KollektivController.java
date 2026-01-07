package com.example.BerlinerKollektivRanking.Controller;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Service.KollektivService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KollektivController {

    private final KollektivService kollektivService;

    public KollektivController(KollektivService kollektivService) {
        this.kollektivService = kollektivService;
    }

    @GetMapping("/kollektivs")
    public List<Kollektiv> getAllKollektivs() {
        return kollektivService.getAllKollektivs();
    }

    @GetMapping("/kollektivs/{id}")
    public Kollektiv getKollektivById(@PathVariable Long id) {
        return kollektivService.getKollektivById(id).orElse(null);
    }

    @PostMapping("/kollektiv")
    public Kollektiv createKollektiv(@RequestBody Kollektiv kollektiv) {
        return kollektivService.saveKollektiv(kollektiv);
    }

    @DeleteMapping("/kollektivs/{id}")
    public void deleteKollektivById(@PathVariable Long id) {
        kollektivService.deleteKollektivById(id);
    }

    @GetMapping("/rankedKollektivs")
    public List<Kollektiv> getRankedKollektivs() {
        return kollektivService.getRankedKollektivs();
    }

    @GetMapping("/sortedByGenreKollektivs")
    public List<Kollektiv> getSortedByGenreKollektivs() {
        return kollektivService.getSortedByGenreKollektivs();
    }
}
