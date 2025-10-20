package com.example.BerlinerKollektivRanking;

import java.util.List;

public class Kollektiv {

    private String name;
    private String genre;
    private List<Dj> residentDjs;
    private String residentClub;
    private String description;
    private List<Integer> bewertungen;
    private double durchschnittsBewertung;


    public Kollektiv(String name, String genre, double durchschnittsBewertung) {
        this.name = name;
        this.genre = genre;
        this.durchschnittsBewertung = durchschnittsBewertung;

        BerlinerKollektivRankingApplication.kollektivList.add(this);
    }

    public List<Dj> getResidentDjs() {
        return residentDjs;
    }

    public List<Integer> getBewertungen() {
        return bewertungen;
    }

    public void setBewertungen(List<Integer> bewertungen) {
        this.bewertungen = bewertungen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResidentDjs(List<Dj> residentDjs) {
        this.residentDjs = residentDjs;
    }

    public double getDurchschnittsBewertung() {
        return durchschnittsBewertung;
    }

    public void setDurchschnittsBewertung(double durchschnittsBewertung) {
        this.durchschnittsBewertung = durchschnittsBewertung;
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

    public void addBewertung(int newBewertung) {
        this.bewertungen.add(newBewertung);
        setDurchschnittsBewertung(calculateDurchschnittBeweertung(bewertungen));
    }

    public double calculateDurchschnittBeweertung(List<Integer> bewertung) {
        double gesamt = 0;
        for (int i = 0; i < bewertung.size(); i++) {
            gesamt += bewertung.get(i);
        }

        return gesamt / bewertung.size();
    }
}
