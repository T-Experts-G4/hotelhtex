package br.com.htex.hotel.model.dto.reserva;

import java.time.LocalDate;
import java.util.List;

public record ReservaFormDto(
    LocalDate checkin,
    LocalDate checkout,
    Boolean status,
    List<Integer> quartos,
    List<Integer> servicos,
    Integer idCliente,
    Integer idFuncionario) {
}
