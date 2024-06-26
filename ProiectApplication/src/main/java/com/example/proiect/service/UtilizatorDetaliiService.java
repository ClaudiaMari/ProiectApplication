package com.example.proiect.service;

import com.example.proiect.model.Utilizator;
import com.example.proiect.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtilizatorDetaliiService implements UserDetailsService {

    @Autowired
    private UtilizatorRepository utilizatorRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilizator utilizator = utilizatorRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilizatorul nu a fost găsit: " + username));

        return User.withUsername(utilizator.getUsername())
                .password(utilizator.getPassword())
                .roles(utilizator.getRol()) // Rolurile utilizatorului, ex. "USER", "ADMIN"
                .build();
    }
}
