package br.com.htex.hotel.model;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    @OneToOne(cascade = CascadeType.ALL )
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, Usuario usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
