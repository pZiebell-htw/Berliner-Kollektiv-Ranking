package com.example.BerlinerKollektivRanking.Service;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Repository.KollektivRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class KollektivService {

    private final KollektivRepository kollektivRepository;

    public KollektivService(KollektivRepository kollektivRepository) {
        this.kollektivRepository = kollektivRepository;
    }

    public List<Kollektiv> getAllKollektivs() {
        return kollektivRepository.findAll();
    }

    public Optional<Kollektiv> getKollektivById(Long id) { return kollektivRepository.findById(id);}

    public Kollektiv saveKollektiv(Kollektiv kollektiv) { return kollektivRepository.save(kollektiv);}

    public void deleteKollektivById(Long id) { kollektivRepository.deleteById(id); }

    public List<Kollektiv> getRankedKollektivs() {
        List<Kollektiv> kollektivs = kollektivRepository.findAll();
        kollektivs.sort(Comparator.comparing(Kollektiv::getDurchschnittsBewertung).reversed());
        return kollektivs;
    }

    public List<Kollektiv> getKollektivsByGenre(Kollektiv.Genre genre) {
        List<Kollektiv> kollektivs = kollektivRepository.findByGenre(genre);
        kollektivs.sort(Comparator.comparing(Kollektiv::getDurchschnittsBewertung).reversed());
        return kollektivs;
    }

    public List<Kollektiv> getKollektivsByUserId(Long userId) {
        List<Kollektiv> kollektivs = kollektivRepository.findByUserId(userId);
        kollektivs.sort(Comparator.comparing(Kollektiv::getDurchschnittsBewertung).reversed());
        return kollektivs;
    }
}

