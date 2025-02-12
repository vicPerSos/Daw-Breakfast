package com.breakfast.daw.web.controllers;


import java.util.List;
import java.util.Optional;  // <- Importación correcta

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breakfast.daw.persintence.entities.Desayuno;
import com.breakfast.daw.services.DesayunoService;

@RestController
@RequestMapping("/desayunos")
public class DesayunoController {
    @Autowired
    private DesayunoService desayunoService;

    @GetMapping
    public ResponseEntity<List<Desayuno>> getDesayunos() {
        return ResponseEntity.ok(desayunoService.getDesayunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Desayuno> getDesayunoById(@PathVariable int id) {
        Optional<Desayuno> desayuno = this.desayunoService.getDesayunoById(id);
        if (desayuno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(desayuno.get());
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
        Optional<Desayuno> desayuno = this.desayunoService.getDesayunoById(id);
        if (desayuno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.desayunoService.deleteDesayuno(id));
    }



}
