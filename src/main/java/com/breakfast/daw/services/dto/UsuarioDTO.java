package com.breakfast.daw.services.dto;

import java.util.List;

import org.hibernate.annotations.SecondaryRow;

import com.breakfast.daw.persintence.entities.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private int id;

    private String userName;

    private String email;

    private List<Review> reviews;

}
