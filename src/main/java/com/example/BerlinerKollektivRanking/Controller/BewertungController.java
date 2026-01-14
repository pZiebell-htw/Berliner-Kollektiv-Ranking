package com.example.BerlinerKollektivRanking.Controller;

import com.example.BerlinerKollektivRanking.Model.Bewertung;
import com.example.BerlinerKollektivRanking.Service.BewertungService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bewertung")
public class BewertungController {

    private final BewertungService bewertungService;

    public BewertungController(BewertungService bewertungService) {
        this.bewertungService = bewertungService;
    }

    @PostMapping("/add")
    public Bewertung addBewertung(
            @RequestBody Bewertung bewertung,
            @RequestParam Long userId,
            @RequestParam Long kollektivId
    ) {
        return bewertungService.addBewertung(
                bewertung,
                userId,
                kollektivId
        );
    }
}
