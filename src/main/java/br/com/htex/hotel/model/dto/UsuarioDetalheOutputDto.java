package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Usuario;

public class UsuarioDetalheOutputDto {
    private Integer id;
    private String nome;
    private String senha;

    public UsuarioDetalheOutputDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}
