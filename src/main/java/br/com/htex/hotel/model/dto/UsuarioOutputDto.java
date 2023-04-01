package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Usuario;

public class UsuarioOutputDto {
    private Integer id;
    private String nome;
    private String senha;

    public UsuarioOutputDto(Usuario usuario){
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
