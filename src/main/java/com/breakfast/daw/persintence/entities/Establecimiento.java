package com.breakfast.daw.persintence.entities;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "establecimiento")
public class Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String nombre;
    @Column(length = 150)
    private String descripcion;
    @Column(length = 255)
    private String ubicacion;
    @Column(columnDefinition = "DECIMAL(3,2)")
    private Double puntuacion;

    @OneToMany(mappedBy = "establecimiento", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Desayuno> desayunos;

}
