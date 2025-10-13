package com.example.BerlinerKollektivRanking;

import java.util.List;

public class Kollektiv {

    private String name;
    private String genre;
    private List<Dj> residentDjs;
    private String residentClub;

    public Kollektiv(String name, String genre, String residentClub) {
        this.name = name;
        this.genre = genre;
    }


    public String getName() {
        return name;
    }

    public String getResidentClub() {
        return residentClub;
    }

    public String getGenre() {
        return genre;
    }

    public List<Dj> getResidentDJs() {
        return residentDjs;
    }

    public void setResidentDJs(List<Dj> residentDjs) {
        this.residentDjs = residentDjs;
    }

    public void setResidentClub(String residentClub) {
        this.residentClub = residentClub;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public void addResidentDJ(Dj newDj) {
        this.residentDjs.add(newDj);
    }
}
