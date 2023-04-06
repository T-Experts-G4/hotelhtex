package br.com.htex.hotel.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record ClienteDto(
        @NotBlank(message = "O campo precisa ser preenchido")
        String nome,
        @NotBlank(message = "O campo precisa ser preenchido")
        String cpf,
        @NotNull(message = "O campo precisa ser preenchido")
        Integer idUsuario
) {
    public ClienteDto toCliente(){
        return new ClienteDto(
                this.nome,
                this.cpf,
                this.idUsuario
        );
    }
}