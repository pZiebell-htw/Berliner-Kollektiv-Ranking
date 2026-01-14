package com.example.BerlinerKollektivRanking.Repository;

import com.example.BerlinerKollektivRanking.Model.Bewertung;
import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BewertungRepository extends JpaRepository<Bewertung, Long> {
    Optional<Bewertung> findByUserAndKollektiv(User user, Kollektiv kollektiv);
}
