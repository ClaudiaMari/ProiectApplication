package com.example.proiect.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Numele autorului este obligatoriu")
    private String nume;

    @NotBlank(message = "Prenumele autorului este obligatoriu")
    private String prenume;

    @Past(message = "Data nașterii trebuie să fie în trecut")
    private LocalDate dataNasterii;

    @OneToMany(mappedBy = "autor")
    private Set<Carte> carti;

    // Puteți adăuga și alte câmpuri relevante, cum ar fi naționalitate, biografie, etc.
}