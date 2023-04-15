package br.com.htex.hotel.model;

import br.com.htex.hotel.model.dto.UsuarioFormInputDto;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String senha;
    public Usuario(){}

    public Usuario(Integer id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(UsuarioFormInputDto usuarioFormInputDto) {
        this.email = usuarioFormInputDto.email();
        this.senha = usuarioFormInputDto.senha();
    }

    public Integer getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
}