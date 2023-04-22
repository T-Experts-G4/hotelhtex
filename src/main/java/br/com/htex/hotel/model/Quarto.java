package br.com.htex.hotel.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name="quartos")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numero;
    private String nome;
    private BigDecimal preco;
    private Boolean disponivel;
    @ManyToOne
    private Hotel hotel;

    public Quarto() { }

    public Quarto(Integer numero, String nome, BigDecimal preco, Boolean disponivel, Hotel hotel) {
        this.numero = numero;
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }
    public String getNome() { return nome; }
    public BigDecimal getPreco() {
        return preco;
    }
    public Boolean getDisponivel() {
        return disponivel;
    }
    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }


    public Hotel getHotel() {
        return hotel;
    }


}
