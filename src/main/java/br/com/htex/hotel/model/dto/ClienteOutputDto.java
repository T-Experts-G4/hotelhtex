package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Cliente;

public record ClienteOutputDto(
        Integer id,
        String nome,
        String cpf,
        String nomeUsuario
) {

    public ClienteOutputDto(Cliente cliente) {
        this(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getUsuario().getNome()
        );
    }
}