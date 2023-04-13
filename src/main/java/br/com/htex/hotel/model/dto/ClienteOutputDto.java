package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Endereco;

public record ClienteOutputDto(
        Integer id,
        String nome,
        String cpf,
        String telefone,
        Endereco endereco,
        String nomeUsuario
) {

    public ClienteOutputDto(Cliente cliente) {
        this(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getTelefone(),
                cliente.getEndereco(),
                cliente.getUsuario().getEmail()
        );
    }
}