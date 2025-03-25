package com.aversi.organizer.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeController {
    
    @GetMapping("/")
    public String Welcome() {
        return new String("Bem vindo a gestão de projeto");
    }
    
}
