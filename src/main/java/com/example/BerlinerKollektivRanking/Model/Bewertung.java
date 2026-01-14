package com.example.BerlinerKollektivRanking.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class Bewertung {


    public Bewertung() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bewertung_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kollektiv_id")
    private Kollektiv kollektiv;

    private int bewertung;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Kollektiv getKollektiv() {
        return kollektiv;
    }

    public void setKollektiv(Kollektiv kollektiv) {
        this.kollektiv = kollektiv;
    }

    public int getBewertung() {
        return bewertung;
    }

    public void setBewertung(int bewertung) {
        this.bewertung = bewertung;
    }
}
