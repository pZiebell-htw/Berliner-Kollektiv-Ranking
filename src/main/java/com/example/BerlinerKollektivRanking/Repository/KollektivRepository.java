package com.example.BerlinerKollektivRanking.Repository;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KollektivRepository extends CrudRepository<Kollektiv, Long> {
}
