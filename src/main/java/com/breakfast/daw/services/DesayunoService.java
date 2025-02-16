package com.breakfast.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breakfast.daw.persintence.entities.Desayuno;
import com.breakfast.daw.persintence.entities.Establecimiento;
import com.breakfast.daw.persintence.repositories.DesayunoRepository;

@Service
public class DesayunoService {
    @Autowired
    private DesayunoRepository desayunoRepository;
    @Autowired
    private EstablecimientoService establecimientoService;

    public List<Desayuno> getDesayunos() {
        return desayunoRepository.findAll();
    }

    public Optional<Desayuno> getDesayunoById(int id) {
        return desayunoRepository.findById(id);

    }

    public Desayuno createDesayuno(Desayuno desayuno) {
        if(desayuno.getImagen().equals("")|| desayuno.getImagen().isEmpty()){
            desayuno.setImagen("https://i.pinimg.com/736x/6d/7a/43/6d7a43e03c4a75a218a47bb6fd5bfcd0.jpg");
        }

        return desayunoRepository.save(desayuno);
    }

    public Desayuno updateDesayuno(Desayuno desayuno) {
        return desayunoRepository.save(desayuno);
    }

    public Desayuno deleteDesayuno(int id) {
        Desayuno desayuno = getDesayunoById(id).get();
        this.desayunoRepository.delete(desayuno);
        return desayuno;
    }

    public List<Desayuno> getDesayunosOrderByPuntuacionDesc() {
        return this.desayunoRepository.findAllByOrderByPuntuacionDesc();
    }

    public List<Desayuno> getDesayunosByEstablecimetosOrderByPuntuacionDesc(int id) {
        Establecimiento establecimiento = this.establecimientoService.getEstablecimientoById(id).get();
        return this.desayunoRepository.findByEstablecimientoOrderByPuntuacionDesc(establecimiento);
    }

    public List<Desayuno> getDesayunosByEstablecimetosOrderByPrecioAsc(int id) {
        Establecimiento establecimiento = this.establecimientoService.getEstablecimientoById(id).get();
        return this.desayunoRepository.findByEstablecimientoOrderByPrecioAsc(establecimiento);
    }

    public List<Desayuno> getDesayunosByEstablecimiento(int id) {
        Establecimiento establecimiento = this.establecimientoService.getEstablecimientoById(id).get();
        return this.desayunoRepository.findByEstablecimiento(establecimiento);
    }

    public Desayuno cambiarImagen(Desayuno desayuno, String imagen) {
        desayuno.setImagen(imagen);
        return this.desayunoRepository.save(desayuno);
    }

    public boolean desayunoIsPresent(int id) {
        return this.desayunoRepository.existsById(id);
    }
}
