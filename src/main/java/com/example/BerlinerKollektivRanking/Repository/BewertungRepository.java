package com.example.BerlinerKollektivRanking.Repository;

import com.example.BerlinerKollektivRanking.Model.Bewertung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BewertungRepository extends JpaRepository<Bewertung, Long> {
}
