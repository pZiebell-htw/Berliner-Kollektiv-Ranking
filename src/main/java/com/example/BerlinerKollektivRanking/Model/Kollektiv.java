package com.example.BerlinerKollektivRanking.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"kollektiv\"")
public class Kollektiv {

    //
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //




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

    @Column(columnDefinition = "TEXT")
    private String beschreibung;

    private String soundcloudUrl;
    private String instagramUrl;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "kollektiv_alle_djs_names")
    private List<String> alleDjsNames = new ArrayList<>();

    private double durchschnittsBewertung;

    @OneToMany(
            mappedBy = "kollektiv",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Bewertung> bewertungen = new ArrayList<>();


    private String residentClub;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public List<Bewertung> getBewertungen() {
        return bewertungen;
    }

    public String getResidentClub() { return residentClub; }
    public void setResidentClub(String residentClub) { this.residentClub = residentClub; }


    public void addBewertung(Bewertung bewertung) {
        bewertungen.add(bewertung);
        bewertung.setKollektiv(this);
        updateDurchschnittsBewertung();
    }


    public void updateDurchschnittsBewertung() {
        if (bewertungen.isEmpty()) {
            this.durchschnittsBewertung = 0;
            return;
        }

        double summe = 0;
        for (Bewertung b : bewertungen) {
            summe += b.getBewertung();
        }

        this.durchschnittsBewertung = summe / bewertungen.size();
    }

}
