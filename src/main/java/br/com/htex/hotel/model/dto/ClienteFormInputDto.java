package br.com.htex.hotel.model.dto;

import br.com.htex.hotel.model.Cliente;

import javax.validation.constraints.NotBlank;

public class ClienteFormInputDto {
    @NotBlank(message = "O campo precisa ser preenchido")
    private String nome;
    @NotBlank(message = "O campo precisa ser preenchido")
    private String cpf;
    @NotBlank(message = "O campo precisa ser preenchido")
    private Integer idUsuario;

    public ClienteFormInputDto(String nome, String cpf, Integer idUsuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() { return cpf; }

    public Integer getidUsuario() { return idUsuario; }

    public ClienteFormInputDto toCliente(){
        return new ClienteFormInputDto(
                this.nome,
                this.cpf,
                this.idUsuario
        );
    }
}
