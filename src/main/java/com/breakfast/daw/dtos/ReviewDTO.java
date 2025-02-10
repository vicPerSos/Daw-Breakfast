package com.breakfast.daw.dtos;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {
	
	private int id;
	private int desayunoId;
	private Date fecha;
    private int puntuacion;
    private String comentario;
    private int usuarioId;

    public ReviewDTO(int id, int puntuacion, String comentario, int desayunoId, int usuarioId) {
        this.id = id;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.desayunoId = desayunoId;
        this.usuarioId = usuarioId;

    }
}
