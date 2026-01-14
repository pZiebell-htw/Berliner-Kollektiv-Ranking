package com.example.BerlinerKollektivRanking.Controller;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Service.KollektivService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kollektiv")
public class KollektivController {

    private final KollektivService kollektivService;

    public KollektivController(KollektivService kollektivService) {
        this.kollektivService = kollektivService;
    }

    @GetMapping("/all")
    public List<Kollektiv> getAllKollektivs() {
        return kollektivService.getAllKollektivs();
    }

    @GetMapping("/{id}")
    public Kollektiv getKollektivById(@PathVariable Long id) {
        return kollektivService.getKollektivById(id).orElse(null);
    }

    @PostMapping("/create")
    public Kollektiv createKollektiv(@RequestBody Kollektiv kollektiv,
                                     @RequestParam Long userId) {
        return kollektivService.saveKollektiv(kollektiv, userId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteKollektivById(@PathVariable Long id) {
        kollektivService.deleteKollektivById(id);
    }

    @GetMapping("/ranked")
    public List<Kollektiv> getRankedKollektivs() {
        return kollektivService.getRankedKollektivs();
    }

    @GetMapping("/genre")
    public List<Kollektiv> getByGenre(@RequestParam(required = false) Kollektiv.Genre genre) {
        if (genre != null) {
            return kollektivService.getKollektivsByGenre(genre);
        } else {
            return kollektivService.getAllKollektivs();
        }
    }

    @GetMapping("/user/{userId}")
    public List<Kollektiv> getByUser(@PathVariable Long userId) {
        return kollektivService.getKollektivsByUserId(userId);
    }


}