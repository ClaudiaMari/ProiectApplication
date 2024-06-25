package com.example.proiect.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Recenzie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carte_id")
    private Carte carte;

    @ManyToOne
    @JoinColumn(name = "utilizator_id")
    private Utilizator utilizator;

    private String text;
    private int rating;
    private LocalDateTime dataPublicarii;
}