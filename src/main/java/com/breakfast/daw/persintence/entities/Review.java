package com.breakfast.daw.persintence.entities;

import java.sql.Date;

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
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date fecha;

    private Double precio;

    private String imagen;

    private int puntuacion;

    private String comentario;
    
    @ManyToOne
    @JoinColumn(name = "breakfastId", referencedColumnName = "id")
    private Desayuno desayuno;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Usuario usuario;

}
