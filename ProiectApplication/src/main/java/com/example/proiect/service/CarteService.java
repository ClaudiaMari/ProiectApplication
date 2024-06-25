package com.example.proiect.service;

import com.example.proiect.model.Carte;
import com.example.proiect.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarteService {

    @Autowired
    private CarteRepository carteRepository;

    public Page<Carte> getAllCarti(Pageable pageable) {
        return carteRepository.findAll(pageable);
    }

    public Carte saveCarte(Carte carte) {
        return carteRepository.save(carte);
    }
}