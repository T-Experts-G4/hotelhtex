package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Usuario;

import javax.validation.constraints.NotBlank;

public record UsuarioFormInputDto(
        @NotBlank(message = "O campo precisa ser preenchido")
        String nome,
        @NotBlank(message = "O campo precisa ser preenchido")
        String senha
) {
    public Usuario toUsuario(){
        return new Usuario(
                this.nome,
                this.senha
        );
    }
}