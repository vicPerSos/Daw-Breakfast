package com.breakfast.daw.persintence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.breakfast.daw.persintence.entities.Desayuno;

@Repository
public interface DesayunoRepository extends JpaRepository<Desayuno, Integer> {

}
