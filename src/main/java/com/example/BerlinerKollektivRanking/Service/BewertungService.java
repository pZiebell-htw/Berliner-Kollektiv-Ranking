package com.example.BerlinerKollektivRanking.Service;

import com.example.BerlinerKollektivRanking.Model.Bewertung;
import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Model.User;
import com.example.BerlinerKollektivRanking.Repository.BewertungRepository;
import com.example.BerlinerKollektivRanking.Repository.KollektivRepository;
import com.example.BerlinerKollektivRanking.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BewertungService {

    private final BewertungRepository bewertungRepository;
    private final UserRepository userRepository;
    private final KollektivRepository kollektivRepository;

    public BewertungService(
            BewertungRepository bewertungRepository,
            UserRepository userRepository,
            KollektivRepository kollektivRepository
    ) {
        this.bewertungRepository = bewertungRepository;
        this.userRepository = userRepository;
        this.kollektivRepository = kollektivRepository;
    }

    @Transactional
    public Bewertung addBewertung(Bewertung bewertung, Long userId, Long kollektivId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User nicht gefunden"));

        Kollektiv kollektiv = kollektivRepository.findById(kollektivId)
                .orElseThrow(() -> new IllegalArgumentException("Kollektiv nicht gefunden"));

        Bewertung existing = bewertungRepository
                .findByUserAndKollektiv(user, kollektiv)
                .orElse(null);

        if (existing != null) {
            existing.setBewertung(bewertung.getBewertung());
            return bewertungRepository.save(existing);
        }

        bewertung.setUser(user);
        bewertung.setKollektiv(kollektiv);

        kollektiv.addBewertung(bewertung);

        bewertungRepository.save(bewertung);
        kollektivRepository.save(kollektiv);

        return bewertung;
    }

}
