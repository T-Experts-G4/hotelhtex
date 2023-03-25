package br.com.htex.hotel.model;

public class Usuario {
    private Integer id;
    private String nome;
    private String senha;
    public Usuario(Integer id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(String nome, String senha) {
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
    @Override
    public String toString() {
        if (id == null){
            return "Usuario{" +
                    "nome=" + nome +
                    ", senha='" + senha + '\''+
                    '}';
        }
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
