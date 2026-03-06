package com.teste.api.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste.api.model.Saudacao;

@RestController
public class SaudacaoController {
    private static final String TEMPLATE = "Olá, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/saudacao")
    public Saudacao saudacao(@RequestParam(defaultValue = "Mundo") String nome) {
        return new Saudacao(counter.incrementAndGet(), String.format(TEMPLATE, nome));
    }
}