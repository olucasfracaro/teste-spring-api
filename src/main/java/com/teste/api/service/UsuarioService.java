package com.teste.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.api.model.Usuario;
import com.teste.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario criarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public Optional<Usuario> getUsuario(int id) {
        return repository.findById(id);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll(); // O JpaRepository faz o 'SELECT * FROM usuarios'
    }
}
