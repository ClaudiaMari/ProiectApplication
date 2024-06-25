package com.example.proiect.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;

    @ManyToMany(mappedBy = "categorii")
    private Set<Carte> carti;
}