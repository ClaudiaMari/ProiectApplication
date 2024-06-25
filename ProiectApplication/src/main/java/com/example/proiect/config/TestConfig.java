package com.example.proiect.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    // Configurări specifice pentru mediul de testare
}