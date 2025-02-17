package com.breakfast.daw.services.mapper;

import com.breakfast.daw.persintence.entities.Usuario;
import com.breakfast.daw.services.dto.UsuarioDTO;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUserName(usuario.getUserName());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setReviews(usuario.getReviews());
        return usuarioDTO;
    }

}
