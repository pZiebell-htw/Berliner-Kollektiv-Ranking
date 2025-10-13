package com.example.BerlinerKollektivRanking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DjController {

    @GetMapping("/djs")
    public List<Dj> getAllDJs() {
        return List.of(
                new Dj("DJ Example 1", "Techno", new Kollektiv("Kollektiv Example 1", "Techno", "Club Example 1"))
        );
    }

}
