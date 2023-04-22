package br.com.htex.hotel.controller;

import br.com.htex.hotel.model.Servico;
import br.com.htex.hotel.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServicoController {

    @Autowired
    ServicoService servicoService;
    @GetMapping("/servicos")
    public ResponseEntity<List <Servico>> servicos() {
        return ResponseEntity.ok().body(servicoService.buscarServicos());
    }

}
