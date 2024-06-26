package com.example.proiect.controller;

import com.example.proiect.model.Utilizator;
import com.example.proiect.service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilizatori")
public class UtilizatorController {

    @Autowired
    private UtilizatorService utilizatorService;

    @GetMapping
    public List<Utilizator> listaUtilizatori() {
        return utilizatorService.getAllUtilizatori();
    }

    @GetMapping("/{id}")
    public Utilizator detaliiUtilizator(@PathVariable Long id) {
        return utilizatorService.getUtilizatorById(id);
    }

    @PostMapping
    public Utilizator adaugaUtilizator(@RequestBody Utilizator utilizator) {
        return utilizatorService.saveUtilizator(utilizator);
    }

    @PutMapping("/{id}")
    public Utilizator actualizeazaUtilizator(@PathVariable Long id, @RequestBody Utilizator utilizatorActualizat) {
        Utilizator utilizatorExistent = utilizatorService.getUtilizatorById(id);
        utilizatorExistent.setUsername(utilizatorActualizat.getUsername());
        utilizatorExistent.setPassword(utilizatorActualizat.getPassword());
        utilizatorExistent.setEmail(utilizatorActualizat.getEmail());
        utilizatorExistent.setRol(utilizatorActualizat.getRol());
        return utilizatorService.saveUtilizator(utilizatorExistent);
    }

    @DeleteMapping("/{id}")
    public void stergeUtilizator(@PathVariable Long id) {
        utilizatorService.deleteUtilizator(id);
    }
}
