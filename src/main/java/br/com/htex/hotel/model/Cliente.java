package br.com.htex.hotel.model;

public class Cliente {
    private Integer id;
    private String nome;
    private String cpf;
    private Usuario usuario;

    public Cliente(Integer id, String nome, String cpf, Usuario usuario) {
        this.id = id;
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
