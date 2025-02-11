package com.breakfast.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breakfast.daw.persintence.entities.Usuario;
import com.breakfast.daw.persintence.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(int id) {
        return usuarioRepository.findById(id);
    }

    public Usuario createUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Usuario deleteUsuario(int id) {
        Usuario usuario = this.usuarioRepository.findById(id).get();
        this.usuarioRepository.deleteById(id);
        return usuario;
    }

    public boolean usuarioIsPresent(int id) {
        return this.usuarioRepository.existsById(id);
    }

}
