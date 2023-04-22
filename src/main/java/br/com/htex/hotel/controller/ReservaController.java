package br.com.htex.hotel.controller;

import br.com.htex.hotel.model.dto.reserva.ReservaCancelarDto;
import br.com.htex.hotel.model.dto.reserva.ReservaFormDto;
import br.com.htex.hotel.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @PostMapping("/cadastra")
    public ResponseEntity<String> cadastraReserva(
            @RequestBody ReservaFormDto reservaFormDto
    ) {
        try {
            this.reservaService.cadastraReserva(reservaFormDto);
            return ResponseEntity.status(200).body("Reserva cadastrada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarReservas() {
        try {
            return ResponseEntity.status(200).body(this.reservaService.listarReservas());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/cancelar")
    public ResponseEntity<String> cancelarReserva(
            @RequestBody ReservaCancelarDto reservaCancelarDto
    ) {
        try {
            this.reservaService.cancelarReserva(reservaCancelarDto);
            return ResponseEntity.status(200).body("Reserva cancelada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
