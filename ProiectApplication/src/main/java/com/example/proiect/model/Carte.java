package com.example.proiect.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String titlu;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "editura_id")
    private Editura editura;

    @ManyToMany
    @JoinTable(
            name = "carte_categorie",
            joinColumns = @JoinColumn(name = "carte_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id")
    )
    private Set<Categorie> categorii;

    @OneToMany(mappedBy = "carte")
    private Set<Recenzie> recenzii;
}