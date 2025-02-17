package com.breakfast.daw.services.dto;

import java.sql.Date;

import com.breakfast.daw.persintence.entities.Desayuno;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReviewDTO {
    private int id;

    private Date fecha;

    private Double precio;

    private String imagen;

    private int puntuacion;

    private String comentario;

    private Desayuno desayuno;

    private UsuarioDTO usuario;

}
