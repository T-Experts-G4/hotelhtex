package br.com.htex.hotel.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name="quartos")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numero;
    private BigDecimal preco;
    private Boolean disponivel;
    @ManyToOne
    private Hotel hotel;

    public Quarto() { }

    public Quarto(Integer numero, BigDecimal preco, Boolean disponivel, Hotel hotel) {
        this.numero = numero;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
