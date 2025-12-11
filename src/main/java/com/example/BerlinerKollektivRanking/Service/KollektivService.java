package com.example.BerlinerKollektivRanking.Service;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Repository.KollektivRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class KollektivService {

    private final KollektivRepository repository;

    public KollektivService(KollektivRepository repository) {
        this.repository = repository;
    }

    public List<Kollektiv> getAll() {
        return repository.findAll();
    }

    public Optional<Kollektiv> getById(Long id) {
        return repository.findById(id);
    }

    public Kollektiv save(Kollektiv kollektiv) {
        return repository.save(kollektiv);
    }

    public List<Kollektiv> getRanked() {
        List<Kollektiv> list = repository.findAll();
        list.sort(Comparator.comparing(Kollektiv::getDurchschnittsBewertung).reversed());
        return list;
    }

    public List<Kollektiv> getSortedByGenre() {
        List<Kollektiv> list = repository.findAll();
        list.sort(Comparator.comparing(Kollektiv::getGenre));
        return list;
    }
}

