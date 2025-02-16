package com.breakfast.daw.services.mapper;

import com.breakfast.daw.persintence.entities.Review;
import com.breakfast.daw.services.dto.ReviewDTO;

public class ReviewMapper {
    public static ReviewDTO toDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setFecha(review.getFecha());
        reviewDTO.setImagen(review.getImagen());
        reviewDTO.setPrecio(review.getPrecio());
        reviewDTO.setPuntuacion(review.getPuntuacion());
        reviewDTO.setComentario(review.getComentario());
        reviewDTO.setDesayuno(review.getDesayuno());
        reviewDTO.setUsuario(review.getUsuario());

        return reviewDTO;
    }

}
