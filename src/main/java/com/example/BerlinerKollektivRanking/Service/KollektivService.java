package com.example.BerlinerKollektivRanking.Service;

import com.example.BerlinerKollektivRanking.Model.Dj;
import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Repository.KollektivRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KollektivService {

    @Autowired
    KollektivRepository repo;

    public Kollektiv save(Kollektiv kollektiv){
        return repo.save(kollektiv);
    }

    public Kollektiv get(String id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public static List<Kollektiv> kollektivList = new ArrayList<>();

}
