package com.teste.api.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teste.api.dto.UsuarioDTO;
import com.teste.api.model.Usuario;
import com.teste.api.service.UsuarioService;

@RestController
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @GetMapping("/usuario/{id}")
    public Usuario getUsuario(@PathVariable int id) {
        Optional<Usuario> usuario = usuarioService.getUsuario(id);
        return usuario.orElse(null);
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody UsuarioDTO usuario) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(usuario.nome());
        novoUsuario.setIdade(usuario.idade());
        novoUsuario.setEmail(usuario.email());

        Usuario salvo = usuarioService.criarUsuario(novoUsuario);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }
}
