package com.teste.api.model;

public class Soma {
    private final int resultado;

    public Soma(int a, int b) {
        this.resultado = a + b;
    }

    public int getResultado() {
        return resultado;
    }

    public String mostrarResultado() {
        return String.format("A soma é: %d", this.getResultado());
    }
}