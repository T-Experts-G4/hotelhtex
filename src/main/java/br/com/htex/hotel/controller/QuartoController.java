package br.com.htex.hotel.controller;

import br.com.htex.hotel.model.Quarto;
import br.com.htex.hotel.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/quartos")
public class QuartoController {

    @Autowired
    QuartoService quartoService;

    @GetMapping("/hotel/{id}/listaQuartosDisponiveis")
    public ResponseEntity<?> listaQuartos(
            @PathVariable Integer id
    ){
        try {
            List<Quarto> quartos = this.quartoService.listaQuartosDisponivelHotel(id);
            return ResponseEntity.ok(quartos);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}