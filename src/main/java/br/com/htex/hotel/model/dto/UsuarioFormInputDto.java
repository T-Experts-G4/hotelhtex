package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Usuario;

import javax.validation.constraints.NotBlank;

public class UsuarioFormInputDto {
    private Integer id;
    @NotBlank(message = "O campo precisa ser preenchido")
    private String nome;
    @NotBlank(message = "O campo precisa ser preenchido")
    private String senha;

    public UsuarioFormInputDto(Integer id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
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

    public Usuario toUsuario(){
        return new Usuario(
                this.id,
                this.nome,
                this.senha
        );
    }
}
