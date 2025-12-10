package com.example.BerlinerKollektivRanking.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Kollektiv {

    public enum Genre {
        Trance, Hardtrance, Techno, Hardtechno, Groove, House, Hardhouse, Gabber, Hardcore, Hardstyle, Tekk, Hardtekk
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String bildUrl;
    private String beschreibung;
    private String soundcloudUrl;
    private String instagramUrl;

    @ElementCollection
    private List<String> alleDjsNames = new ArrayList<>();

    private double durchschnittsBewertung;

    @ElementCollection
    private List<Integer> bewertungen = new ArrayList<>();

    // --------- Parameterloser Konstruktor (wichtig für JPA) ---------
    public Kollektiv() {}

    // --------- Konstruktor mit Feldern ---------
    public Kollektiv(String name, Genre genre, String bildUrl, String soundcloudUrl, String instagramUrl, String beschreibung) {
        this.name = name;
        this.genre = genre;
        this.bildUrl = bildUrl;
        this.soundcloudUrl = soundcloudUrl;
        this.instagramUrl = instagramUrl;
        this.beschreibung = beschreibung;
    }

    // --------- Getter & Setter ---------
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }
    public String getBildUrl() { return bildUrl; }
    public void setBildUrl(String bildUrl) { this.bildUrl = bildUrl; }
    public String getBeschreibung() { return beschreibung; }
    public void setBeschreibung(String beschreibung) { this.beschreibung = beschreibung; }
    public String getSoundcloudUrl() { return soundcloudUrl; }
    public void setSoundcloudUrl(String soundcloudUrl) { this.soundcloudUrl = soundcloudUrl; }
    public String getInstagramUrl() { return instagramUrl; }
    public void setInstagramUrl(String instagramUrl) { this.instagramUrl = instagramUrl; }
    public List<String> getAlleDjsNames() { return alleDjsNames; }
    public void setAlleDjsNames(List<String> alleDjsNames) { this.alleDjsNames = alleDjsNames; }
    public double getDurchschnittsBewertung() { return durchschnittsBewertung; }
    public void setDurchschnittsBewertung(double durchschnittsBewertung) { this.durchschnittsBewertung = durchschnittsBewertung; }
    public List<Integer> getBewertungen() { return bewertungen; }
    public void setBewertungen(List<Integer> bewertungen) { this.bewertungen = bewertungen; }
}
