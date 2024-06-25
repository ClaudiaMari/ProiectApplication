package com.example.proiect.service;

import com.example.proiect.model.Autor;
import com.example.proiect.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Page<Autor> getAllAutori(Pageable pageable) {
        return autorRepository.findAll(pageable);
    }

    public Autor getAutorById(Long id) {
        return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor nu a fost găsit"));
    }

    // Alte metode pentru operații CRUD
}