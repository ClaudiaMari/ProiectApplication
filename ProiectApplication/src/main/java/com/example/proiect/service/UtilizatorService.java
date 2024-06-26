package com.example.proiect.service;

import com.example.proiect.model.Utilizator;
import com.example.proiect.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilizatorService {

    @Autowired
    private UtilizatorRepository utilizatorRepository;

    public List<Utilizator> getAllUtilizatori() {
        return utilizatorRepository.findAll();
    }

    public Utilizator getUtilizatorById(Long id) {
        return utilizatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilizatorul nu a fost găsit"));
    }

    public Utilizator saveUtilizator(Utilizator utilizator) {
        return utilizatorRepository.save(utilizator);
    }

    public void deleteUtilizator(Long id) {
        utilizatorRepository.deleteById(id);
    }
}
