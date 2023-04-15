package br.com.htex.hotel.model.dto.reserva;

import br.com.htex.hotel.model.*;

import java.time.LocalDate;
import java.util.List;

public record ReservaDto (
    LocalDate checkin,
    LocalDate checkout,
    Boolean status,
    List<Quarto> quarto,
    List<Servico> servico,
    Cliente cliente,
    Funcionario funcionario
){}
