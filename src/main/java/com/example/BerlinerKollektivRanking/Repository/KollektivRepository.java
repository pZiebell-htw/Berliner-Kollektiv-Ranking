package com.example.BerlinerKollektivRanking.Repository;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KollektivRepository extends JpaRepository<Kollektiv, Long> {


    List<Kollektiv> findByGenre(Kollektiv.Genre genre);

    List<Kollektiv> findByUserId(Long userId);
}
