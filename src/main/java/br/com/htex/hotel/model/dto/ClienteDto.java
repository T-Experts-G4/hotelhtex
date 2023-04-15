package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Endereco;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record ClienteDto(
        @NotBlank(message = "O campo precisa ser preenchido")
        String nome,
        @NotBlank(message = "O campo precisa ser preenchido")
        String cpf,
        @NotBlank(message = "O campo precisa ser preenchido")
        String telefone,
        @NotNull(message = "O campo precisa ser preenchido")
        Endereco endereco,
        @NotNull(message = "O campo precisa ser preenchido")
        Integer idUsuario

) {}