package com.example.proiect.controller;

import com.example.proiect.model.Autor;
import com.example.proiect.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autori")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public String listaAutori(Model model, Pageable pageable) {
        Page<Autor> autori = autorService.getAllAutori(pageable);
        model.addAttribute("autori", autori);
        return "autor/lista";
    }

    @GetMapping("/{id}")
    public String detaliiAutor(@PathVariable Long id, Model model) {
        Autor autor = autorService.getAutorById(id);
        model.addAttribute("autor", autor);
        return "autor/detalii";
    }

    // Alte metode pentru adăugare, editare, ștergere
}