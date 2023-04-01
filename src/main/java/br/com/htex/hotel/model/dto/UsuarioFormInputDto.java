package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Usuario;

import javax.validation.constraints.NotBlank;

public class UsuarioFormInputDto {
    @NotBlank(message = "O campo precisa ser preenchido")
    private String nome;
    @NotBlank(message = "O campo precisa ser preenchido")
    private String senha;

    public UsuarioFormInputDto(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario toUsuario(){
        return new Usuario(
                this.nome,
                this.senha
        );
    }
}
