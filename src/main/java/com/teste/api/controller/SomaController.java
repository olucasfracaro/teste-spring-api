package com.teste.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste.api.model.Soma;

@RestController
public class SomaController {

    @GetMapping("/soma")
    public String soma(@RequestParam int a, @RequestParam int b) {
        return new Soma(a, b).mostrarResultado();
    }
}
