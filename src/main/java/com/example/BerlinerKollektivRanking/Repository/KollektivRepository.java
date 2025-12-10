package com.example.BerlinerKollektivRanking.Repository;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KollektivRepository extends JpaRepository<Kollektiv, String> {
}

