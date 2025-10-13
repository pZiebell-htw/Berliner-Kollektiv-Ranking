package com.example.BerlinerKollektivRanking;

import java.util.List;

public class Kollektiv {

    private String name;
    private String genre;
    private List<DJ> residentDJs;
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

    public List<DJ> getResidentDJs() {
        return residentDJs;
    }

    public void setResidentDJs(List<DJ> residentDJs) {
        this.residentDJs = residentDJs;
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


    public void addResidentDJ(DJ newDj) {
        this.residentDJs.add(newDj);
    }
}
