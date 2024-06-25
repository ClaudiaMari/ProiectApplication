package com.example.proiect.repository;

import com.example.proiect.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    // Metode personalizate de căutare, dacă sunt necesare
}