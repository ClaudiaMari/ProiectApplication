package com.example.proiect.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String rol;

    @OneToMany(mappedBy = "utilizator")
    private Set<Recenzie> recenzii;
}