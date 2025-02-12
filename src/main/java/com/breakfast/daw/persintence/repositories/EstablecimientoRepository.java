package com.breakfast.daw.persintence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.breakfast.daw.persintence.entities.Establecimiento;

@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Integer> {
	
    @Query("SELECT e FROM Establecimiento e ORDER BY e.puntuacion DESC")
    List<Establecimiento> findByPuntuacionDesc();
	
}
