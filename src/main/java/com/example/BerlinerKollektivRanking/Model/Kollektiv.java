package com.example.BerlinerKollektivRanking.Model;

import com.example.BerlinerKollektivRanking.Service.KollektivService;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Kollektiv {

    public Kollektiv() {}

    public enum Genre{
        Trance, Hardtrance, Techno, Hardtechno, Groove, House, Hardhouse,  Gabber, Hardcore, Hardstyle, Tekk, Hardtekk,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private Genre genre;
    private String bildUrl;
    private String beschreibung;
    private String soundcloudUrl;
    private String instagramUrl;
    private String DjName;

    @ElementCollection
    private List<String> alleDjsNames = new ArrayList<>();

    //soll umgesetzt werden wenn user da sind
    private double durchschnittsBewertung;
    @ElementCollection
    private List<Integer> bewertungen = new ArrayList<>();

    // wenn später genug zeit ist
    //private List<Dj> residentDjs = new ArrayList<>();
    //private String residentClub;


    public Kollektiv(String name, Genre genre, String bildUrl, String soundcloudUrl, String instagramUrl, String beschreibung) {

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.genre = genre;
        this.bildUrl = bildUrl;
        this.soundcloudUrl = soundcloudUrl;
        this.instagramUrl = instagramUrl;
        this.beschreibung = beschreibung;
    }



    public List<Integer> getBewertungen() {
        return bewertungen;
    }

    public void setBewertungen(List<Integer> bewertungen) {
        this.bewertungen = bewertungen;
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



    public Genre getGenre() {
        return genre;
    }

    /*
    public String getResidentClub() {
        return residentClub;
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

        public void addResidentDJ(Dj newDj) {
        this.residentDjs.add(newDj);
    }

     public List<Dj> getResidentDjs() {
        return residentDjs;
    }

        public void setResidentDjs(List<Dj> residentDjs) {
        this.residentDjs = residentDjs;
    }

     */

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

    public String getSoundcloudUrl() {
        return soundcloudUrl;
    }

    public void setSoundcloudUrl(String soundcloudUrl) {
        this.soundcloudUrl = soundcloudUrl;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public List<String> getAlleDjsNames() {
        return alleDjsNames;
    }

    public void setAlleDjsNames(List<String> alleDjsNames) {
        this.alleDjsNames = alleDjsNames;
    }

    public String getDjName() {
        return DjName;
    }


    public void setDjName(String djName) {
        DjName = djName;
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
