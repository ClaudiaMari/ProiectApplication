package com.example.proiect.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Editura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private String adresa;
    private String telefon;

    @OneToMany(mappedBy = "editura")
    private Set<Carte> carti;
}