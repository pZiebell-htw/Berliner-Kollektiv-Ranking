package com.example.BerlinerKollektivRanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.BerlinerKollektivRanking.Model.User;


@SpringBootApplication
public class BerlinerKollektivRankingApplication {


    public static void main(String[] args) {
        SpringApplication.run(BerlinerKollektivRankingApplication.class, args);
    }
    User user = new User("fsdfsd", "asdasd", "asdasd");
}
