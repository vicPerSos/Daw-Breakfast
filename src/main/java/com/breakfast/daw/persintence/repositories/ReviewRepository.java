package com.breakfast.daw.persintence.repositories;

import com.breakfast.daw.persintence.entities.Review;
import com.breakfast.daw.persintence.entities.Desayuno;
import com.breakfast.daw.persintence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUsuario(Usuario usuario);
    List<Review> findByDesayuno(Desayuno desayuno);
    List<Review> findAllByOrderByPuntuacionDesc();
    List<Review> findAllByOrderByIdAsc();
    List<Review> findAllByOrderByIdDesc();
}