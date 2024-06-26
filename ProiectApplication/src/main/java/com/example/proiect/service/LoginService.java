package com.example.proiect.service;

import com.example.proiect.model.Utilizator;
import com.example.proiect.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UtilizatorRepository utilizatorRepository;

    @Autowired
    public LoginService(UtilizatorRepository utilizatorRepository) {
        this.utilizatorRepository = utilizatorRepository;
    }

    public boolean authenticate(String username, String password) {
        Optional<Utilizator> utilizatorOptional = utilizatorRepository.findByUsername(username);

        // Verificăm dacă utilizatorul există și parola este corectă
        if (utilizatorOptional.isPresent()) {
            Utilizator utilizator = utilizatorOptional.get();
            if (utilizator.getPassword().equals(password)) {
                return true; // Autentificare reușită
            }
        }
        return false; // Autentificare eșuată
    }
}
