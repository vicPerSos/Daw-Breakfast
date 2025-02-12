package com.breakfast.daw.services;

import java.util.List;

import com.breakfast.daw.persintence.entities.Desayuno;
import com.breakfast.daw.persintence.repositories.DesayunoRepository;

public class DesayunoService {
    private DesayunoRepository desayunoRepository;


    public List<Desayuno> getDesayunos(){
        return desayunoRepository.findAll();
    }
}
