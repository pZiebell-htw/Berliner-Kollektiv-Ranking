package com.example.BerlinerKollektivRanking.Model;

import com.example.BerlinerKollektivRanking.Service.KollektivService;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Kollektiv {

    public enum Genre{
        Trance, Hardtrance, Techno, Hardtechno, Groove, House, Hardhouse,  Gabber, Hardcore, Hardstyle, Tekk, Hardtekk,
    }


    private String id;

    private String name;
    private Genre genre;
    private String bildUrl;
    private String beschreibung;
    private String description;
    private List<Integer> bewertungen;
    private double durchschnittsBewertung;
    private List<Dj> residentDjs;
    private String residentClub;


    public Kollektiv(String name, Genre genre, String bildUrl, String beschreibung) {

        this.name = name;
        this.genre = genre;
        this.beschreibung = beschreibung;
        this.bildUrl = bildUrl;
        this.id = UUID.randomUUID().toString();
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

    public Genre getGenre() {
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

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addResidentDJ(Dj newDj) {
        this.residentDjs.add(newDj);
    }


    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getBildUrl() {
        return bildUrl;
    }

    public void setBildUrl(String bildUrl) {
        this.bildUrl = bildUrl;
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
