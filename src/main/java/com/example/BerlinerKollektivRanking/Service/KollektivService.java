package com.example.BerlinerKollektivRanking.Service;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Repository.KollektivRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KollektivService {

    @Autowired
    private KollektivRepository repo;

    public Kollektiv save(Kollektiv kollektiv){
        return repo.save(kollektiv);
    }

    public Kollektiv getById(String id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Kollektiv nicht gefunden"));
    }

    public List<Kollektiv> getAll(){
        return repo.findAll();
    }
}
