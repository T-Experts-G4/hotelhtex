package br.com.htex.hotel.model;

import br.com.htex.hotel.model.dto.Funcionario;
import br.com.htex.hotel.model.dto.Servico;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name="reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate data;
    private LocalDate checkin;
    private LocalDate checkout;
    private Boolean status;
    @OneToOne
    private Hotel hotel;
    @OneToMany
    private List<Quarto> quarto;
    @OneToMany
    private List<Servico> servico;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Funcionario funcionario;

    public Reserva(LocalDate data, LocalDate checkin, LocalDate checkout, Boolean status, Hotel hotel, List<Quarto> quarto, List<Servico> servico, Cliente cliente, Funcionario funcionario) {
        this.data = data;
        this.checkin = checkin;
        this.checkout = checkout;
        this.status = status;
        this.hotel = hotel;
        this.quarto = quarto;
        this.servico = servico;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public Boolean getStatus() {
        return status;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public List<Quarto> getQuarto() {
        return quarto;
    }

    public List<Servico> getServico() {
        return servico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
