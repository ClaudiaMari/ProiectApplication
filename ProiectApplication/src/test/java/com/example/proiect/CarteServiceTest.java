package com.example.proiect;

import com.example.proiect.model.Carte;
import com.example.proiect.service.CarteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarteServiceTest {

    @Autowired
    private CarteService carteService;

    @Test
    public void testSaveCarte() {
        Carte carte = new Carte();
        carte.setTitlu("Test Carte");
        Carte savedCarte = carteService.saveCarte(carte);
        assertNotNull(savedCarte.getId());
        assertEquals("Test Carte", savedCarte.getTitlu());
    }


}