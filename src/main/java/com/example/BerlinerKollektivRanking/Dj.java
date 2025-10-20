package com.example.BerlinerKollektivRanking;

public class Dj {
    private String name;
    private String genre;
    private Kollektiv kollektiv;


    public Dj(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.kollektiv = kollektiv;

        BerlinerKollektivRankingApplication.djList.add(this);
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

}