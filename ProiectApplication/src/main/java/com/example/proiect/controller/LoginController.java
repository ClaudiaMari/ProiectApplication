//package com.example.proiect.controller;
//
//import org.springframework.stereotype.Controller;
//
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class LoginController {
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//}

package com.example.proiect.controller;

import com.example.proiect.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Returnează pagina de login (login.html)
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = loginService.authenticate(username, password);
        if (isAuthenticated) {
            return "redirect:/home"; // Redirecționează către pagina home sau altă pagină protejată
        } else {
            return "redirect:/login?error=true"; // Redirecționează înapoi la pagina de login cu un mesaj de eroare
        }
    }
}
