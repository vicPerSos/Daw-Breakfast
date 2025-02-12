package com.breakfast.daw.persintence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.breakfast.daw.persintence.entities.Desayuno;
import com.breakfast.daw.persintence.entities.Establecimiento;

public interface DesayunoRepository extends JpaRepository<Desayuno, Integer> {
	List<Desayuno> findAllByOrderByPuntuacionDesc();

	List<Desayuno> findByEstablecimientoOrderByPuntuacionDesc(Establecimiento establecimiento);

	List<Desayuno> findByEstablecimientoOrderByPrecioAsc(Establecimiento establecimiento);

	List<Desayuno> findByEstablecimiento(Establecimiento establecimiento);
}
