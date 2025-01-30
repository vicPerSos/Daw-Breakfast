package com.breakfast.daw.persintence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @JoinColumn(name = "id_establecimiento", referencedColumnName = "id", insertable = false, updatable = false)
    private Establecimiento establecimiento;

    public Desayuno(String nombre, Double precio, String imagen, Double puntuacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        setPuntuacion(puntuacion);
    }

    public void setPuntuacion(Double puntuacion) {
        if (puntuacion > 5) {
            this.puntuacion = 5.0;
        } else if (puntuacion < 0) {
            this.puntuacion = 0.0;
        } else {
            this.puntuacion = puntuacion;
        }
        this.puntuacion = puntuacion;
    }
}
