package com.example.BerlinerKollektivRanking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.BerlinerKollektivRanking.BerlinerKollektivRankingApplication;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class KollektivController {

    @GetMapping("/kollektivs")
    public List<Kollektiv> getAllKollektivs() {
        return BerlinerKollektivRankingApplication.kollektivList;
    }

}