package com.breakfast.daw.persintence.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "desayuno")
@Getter
@Setter
@NoArgsConstructor
public class Desayuno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(length = 30)
    private String nombre;
    @Column(columnDefinition = "DECIMAL(5,2)")
    private Double precio;
    @Column(length = 255)
    private String imagen;
    @Column(columnDefinition = "DECIMAL(3,2)")
    private Double puntuacion;

    @ManyToOne
    @JoinColumn(name = "establecimiento_Id", referencedColumnName = "id")
    private Establecimiento establecimiento;

    @OneToMany(mappedBy = "desayuno")
    private List<Review> reviews;

    public Desayuno(int id, String nombre, Double precio, String imagen, Double puntuacion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.puntuacion = puntuacion;
    }
    
}
