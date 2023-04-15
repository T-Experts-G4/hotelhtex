package br.com.htex.hotel.model;

import br.com.htex.hotel.model.dto.ClienteDto;

import javax.persistence.*;

@Entity(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    @ManyToOne
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente(ClienteDto clienteDto, Usuario usuario, Endereco endereco) {
        this.nome = clienteDto.nome();
        this.cpf = clienteDto.cpf();
        this.telefone = clienteDto.telefone();
        this.endereco = endereco;
        this.usuario = usuario;
    }

    public Cliente(String nome, String cpf, String telefone, Endereco endereco, Usuario usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
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

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void Update(String nome, String cpf, Usuario usuario, String telefone, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.usuario = usuario;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}