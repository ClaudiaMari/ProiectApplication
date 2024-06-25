package com.example.proiect.repository;

import com.example.proiect.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarteRepository extends JpaRepository<Carte, Long> {
    List<Carte> findByTitluContainingIgnoreCase(String titlu);

    @Query("SELECT c FROM Carte c WHERE c.autor.nume = :numeAutor")
    List<Carte> findByNumeAutor(@Param("numeAutor") String numeAutor);

    List<Carte> findByEdituraNume(String numeEditura);
}