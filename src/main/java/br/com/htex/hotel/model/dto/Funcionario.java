package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Usuario;

import javax.persistence.*;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Long matricula;
    private String cargo;
    @OneToOne
    private Usuario usuario;

    public Funcionario(String nome, Long matricula, String cargo, Usuario usuario) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargo = cargo;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
