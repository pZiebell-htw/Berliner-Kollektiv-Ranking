package com.example.BerlinerKollektivRanking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DjController {

        @GetMapping("/djs")
        public String getAllDJs() {
            String allDjs = "";

            for (Dj dj : BerlinerKollektivRankingApplication.djList) {
                allDjs = allDjs + dj.getName() + " " + dj.getGenre() + "\n";
            }

            return allDjs;
        }
}
