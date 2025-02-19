package com.breakfast.daw.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.breakfast.daw.persintence.entities.Desayuno;
import com.breakfast.daw.services.DesayunoService;
import com.breakfast.daw.services.EstablecimientoService;
import com.breakfast.daw.services.dto.ImagenDTO;

@RestController
@RequestMapping("/desayunos")
public class DesayunoController {
    @Autowired
    private DesayunoService desayunoService;

    @Autowired
    private EstablecimientoService establecimientoService;

    @GetMapping
    public ResponseEntity<List<Desayuno>> getDesayunos() {
        return ResponseEntity.ok(desayunoService.getDesayunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Desayuno> getDesayunoById(@PathVariable int id) {
        if (this.desayunoService.desayunoIsPresent(id)) {
            return ResponseEntity.ok(this.desayunoService.getDesayunoById(id).get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Desayuno> createDesayuno(@RequestBody Desayuno desayuno) {
        return ResponseEntity.ok(desayunoService.createDesayuno(desayuno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Desayuno> updateDesayuno(@PathVariable int id, @RequestBody Desayuno desayuno) {
        if (!this.desayunoService.desayunoIsPresent(id)) {
            return ResponseEntity.notFound().build();

        }
        if (desayuno.getId() != id) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(desayunoService.updateDesayuno(desayuno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Desayuno> deleteDesayuno(@PathVariable int id) {
        if (this.desayunoService.desayunoIsPresent(id)) {
            return ResponseEntity.ok(desayunoService.deleteDesayuno(id));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/ordenPuntDesc")
    public ResponseEntity<List<Desayuno>> getDesayunosOrdenDesc() {
        return ResponseEntity.ok(desayunoService.getDesayunosOrderByPuntuacionDesc());
    }

    @GetMapping("/establecimiento/{id}")
    public ResponseEntity<List<Desayuno>> getDesayunosByEstablecimiento(@PathVariable int id) {
        if (!this.establecimientoService.establecimientoIsPresent(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.desayunoService.getDesayunosByEstablecimiento(id));
    }

    @GetMapping("/establecimiento/puntuacion/{id}")
    public ResponseEntity<List<Desayuno>> getDesayunosByEstablecimientoPuntuacion(@PathVariable int id) {
        if (!this.establecimientoService.establecimientoIsPresent(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.desayunoService.getDesayunosByEstablecimetosOrderByPuntuacionDesc(id));
    }
    @GetMapping("/establecimiento/precio/{id}")
    public ResponseEntity<List<Desayuno>> getDesayunosByEstablecimetosOrderByPrecio(@PathVariable int id) {
        if (!this.establecimientoService.establecimientoIsPresent(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.desayunoService.getDesayunosByEstablecimetosOrderByPrecioAsc(id));
    }

    @PutMapping("/imagen/{id}")
    public ResponseEntity<Desayuno> updateImagenDesayuno(@PathVariable int id, @RequestBody ImagenDTO imagen) {
        if (!this.desayunoService.desayunoIsPresent(id)) {
            return ResponseEntity.notFound().build();
        }
        Desayuno desayuno = this.desayunoService.getDesayunoById(id).get();
        if (desayuno.getImagen().equals(imagen)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.desayunoService.cambiarImagen(desayuno, imagen.getImagen()));
    }

}
