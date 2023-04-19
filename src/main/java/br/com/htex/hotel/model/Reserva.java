package br.com.htex.hotel.model;

import br.com.htex.hotel.model.dto.reserva.ReservaDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name="reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private final LocalDate data = LocalDate.now();
    private LocalDate checkin;
    private LocalDate checkout;
    private Boolean statusPago = false;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Quarto> quarto;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Servico> servico;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Funcionario funcionario;

    private Boolean cancelada = false;

    public Reserva() { }
    public Reserva(
            LocalDate checkin,
            LocalDate checkout,
            Boolean status,
            List<Quarto> quarto,
            List<Servico> servico,
            Cliente cliente,
            Funcionario funcionario
    ) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.statusPago = status;
        this.quarto = quarto;
        this.servico = servico;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Reserva(ReservaDto reservaDto) {
        this.checkin = reservaDto.checkin();
        this.checkout = reservaDto.checkout();
        this.statusPago = reservaDto.status();
        this.quarto = reservaDto.quarto();
        this.servico = reservaDto.servico();
        this.cliente = reservaDto.cliente();
        this.funcionario = reservaDto.funcionario();
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
        return statusPago;
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

    public Boolean getCancelada() {
        return cancelada;
    }

    public void setCancelada() {
        this.cancelada = true;
    }
}
