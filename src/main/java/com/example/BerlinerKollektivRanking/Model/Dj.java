package com.example.BerlinerKollektivRanking.Model;

import com.example.BerlinerKollektivRanking.BerlinerKollektivRankingApplication;
import com.example.BerlinerKollektivRanking.Service.DjService;

import java.util.UUID;

public class Dj {
    private String name;
    private String genre;
    private Kollektiv kollektiv;
    private String id;

    public Dj(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.kollektiv = kollektiv;

        DjService.djList.add(this);
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Kollektiv getKollektiv() {
        return kollektiv;
    }

    public void setKollektiv(Kollektiv kollektiv) {
        this.kollektiv = kollektiv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}