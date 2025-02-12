package com.breakfast.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breakfast.daw.persintence.entities.Establecimiento;
import com.breakfast.daw.persintence.repositories.EstablecimientoRepository;

@Service
public class EstablecimientoService {
    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    public List<Establecimiento> getAllEstablecimientos() {
        return this.establecimientoRepository.findAll();
    }

    public Optional<Establecimiento> getEstablecimientoById(int id) {
        return establecimientoRepository.findById(id);
    }

    public Establecimiento createEstablecimiento(Establecimiento establecimiento) {
        return this.establecimientoRepository.save(establecimiento);
    }
    
    public Establecimiento updateEstablecimiento(Establecimiento establecimiento) {
        return this.establecimientoRepository.save(establecimiento);
    }

	public boolean establecimientoIsPresent(int id) {
		return this.establecimientoRepository.existsById(id);	
		}
	
	 public Establecimiento deleteEstablecimiento(int id) {
	        Establecimiento establecimiento = this.establecimientoRepository.findById(id).get();
	        this.establecimientoRepository.deleteById(id);
	        return establecimiento;
	    }
	 
	//ENDPOINT PARA OBTENER LOS ESTABLECIMIENTOS ORDENADOS POR PUNTUACION (DESC) 
	
	 public List<Establecimiento> getPuntuacionDesc() {
	        return establecimientoRepository.findByPuntuacionDesc();
	    }
	 
	 //por que me sale la clase como que me da error si en teoria no me da
	
}
