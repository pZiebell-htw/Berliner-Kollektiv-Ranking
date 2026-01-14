package com.example.BerlinerKollektivRanking.Controller;

import com.example.BerlinerKollektivRanking.Service.BewertungService;
import com.example.BerlinerKollektivRanking.Service.KollektivService;

public class BewertungController {

    private final BewertungService bewertungService;

    public BewertungService(BewertungService bewertungService) {
        this.bewertungService = bewertungService;
    }
}
