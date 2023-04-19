package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.dto.usuario.UsuarioDto;

public record UsuarioClienteDto(
        Integer id,
        String nome,
        String cpf,
        UsuarioDto usuario
) {

    public UsuarioClienteDto(Cliente byUsuario) {
        this(
                byUsuario.getId(),
                byUsuario.getNome(),
                byUsuario.getCpf(),
                new UsuarioDto(byUsuario.getUsuario())
        );
    }
}
