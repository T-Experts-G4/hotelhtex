package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Cliente;

public class ClienteDetalheOutputDto {
    private Integer id;
    private String nome;
    private String cpf;
    private String nomeUsuario;

    public ClienteDetalheOutputDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.nomeUsuario = cliente.getUsuario().getNome();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() { return cpf; }

    public String getNomeUsuario() { return nomeUsuario; }
}
