package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Usuario;

import java.util.List;

public record UsuarioDto(
        Integer id,
        String email
) {
    public UsuarioDto(Usuario usuario) {
        this(
            usuario.getId(),
            usuario.getEmail()
        );
    }

    public UsuarioDto(List<Usuario> usuarios) {
        this(
                usuarios.get(0).getId(),
                usuarios.get(0).getEmail()
        );
    }
}
