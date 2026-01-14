package com.example.BerlinerKollektivRanking.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(
        name = "bewertung",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"user_id", "kollektiv_id"}
        )
)
public class Bewertung {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bewertung_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kollektiv_id", nullable = false)
    private Kollektiv kollektiv;

    @Column(nullable = false)
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
