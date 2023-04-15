package br.com.htex.hotel.model;

import javax.persistence.*;

@Entity(name="hoteis")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cnpj;
    @ManyToOne
    private Endereco endereco;
    private String telefone;

    public Hotel() { }

    public Hotel(String nome, String cnpj, Endereco endereco, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpf() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
}
