package com.breakfast.daw.persintence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.breakfast.daw.persintence.entities.Usuario;

import jakarta.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.password = :password WHERE u.id = :id")
    Usuario updatePasswordById(int id, String Password);

}
