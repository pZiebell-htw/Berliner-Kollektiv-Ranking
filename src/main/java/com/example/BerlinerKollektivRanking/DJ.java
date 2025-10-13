package com.example.BerlinerKollektivRanking;

public class DJ {
    private String name;
    private String genre;
    private Kollektiv kollektiv;


    public DJ(String name, String genre,Kollektiv kollektiv) {
        this.name = name;
        this.genre = genre;
        this.kollektiv = kollektiv;
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