package com.example.proiect.controller;

import com.example.proiect.model.Carte;
import com.example.proiect.service.CarteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carti")
public class CarteController {

    @Autowired
    private CarteService carteService;

    @GetMapping
    public String listaCarti(Model model, Pageable pageable) {
        Page<Carte> carti = carteService.getAllCarti(pageable);
        model.addAttribute("carti", carti);
        return "carte/lista";
    }

    @GetMapping("/adauga")
    public String formularAdaugare(Model model) {
        model.addAttribute("carte", new Carte());
        return "carte/adauga";
    }

    @PostMapping("/adauga")
    public String adaugaCarte(@Valid @ModelAttribute Carte carte, BindingResult result) {
        if (result.hasErrors()) {
            return "carte/adauga";
        }
        carteService.saveCarte(carte);
        return "redirect:/carti";
    }
}