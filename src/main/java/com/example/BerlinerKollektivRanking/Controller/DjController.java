package com.example.BerlinerKollektivRanking.Controller;

import com.example.BerlinerKollektivRanking.Model.Dj;
import com.example.BerlinerKollektivRanking.Service.DjService;
import com.example.BerlinerKollektivRanking.Service.KollektivService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DjController {

        @GetMapping("/djs")
        public String getAllDJs() {
            String allDjs = "";

            for (Dj dj : DjService.djList) {
                allDjs = allDjs + dj.getName() + " " + dj.getGenre() + "\n";
            }

            return allDjs;
        }
}
