package br.com.htex.hotel.model;

import br.com.htex.hotel.model.dto.usuario.UsuarioFormInputDto;
import br.com.htex.hotel.services.UsuarioRoles;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String senha;
    private String usuarioRole = UsuarioRoles.USUARIO.getRole();

    public Usuario() {
    }

    public Usuario(String email, String senha, String usuarioRole) {
        this.email = email;
        this.senha = senha;
        this.usuarioRole = usuarioRole;
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

    public String getUsuarioRole() {
        return usuarioRole;
    }
}