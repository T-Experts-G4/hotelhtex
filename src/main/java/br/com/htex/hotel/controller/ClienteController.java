package br.com.htex.hotel.controller;
import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.ClienteDto;
import br.com.htex.hotel.model.dto.ClienteOutputDto;
import br.com.htex.hotel.model.dto.FuncionarioDto;
import br.com.htex.hotel.model.dto.usuario.UsuarioAdmin;
import br.com.htex.hotel.services.ClienteService;
import br.com.htex.hotel.services.ReservaService;
import br.com.htex.hotel.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ReservaService reservaService;

    @GetMapping("/listaClientes")
    public ResponseEntity<?> listaClientes(
            @RequestBody UsuarioAdmin usuarioAdmin
    ) {
        try {
            Usuario usuario = this.usuarioService.findById(usuarioAdmin.idUsuario());

            List<ClienteOutputDto> clientesOutputDto = this.clienteService.listaClientes(usuario);

            return ResponseEntity.status(200).body(clientesOutputDto);
        } catch (Exception e) {
            return ResponseEntity.status(403).body(e.getMessage());
        }
    }

    @Transactional
    @Transient
    @PostMapping("/cadastra")
    public ResponseEntity<String> cadastra(
            @Valid @RequestBody ClienteDto clienteDto
    ) throws Exception {
        try {
            this.clienteService.cadastrarCliente(clienteDto);

            return ResponseEntity.status(200).body("Cliente cadastrado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/listaReservas/{id}")
    public ResponseEntity<?> listaReservas(
            @PathVariable Integer id
    ){
        try {
            return ResponseEntity.status(200).body(this.reservaService.listaReservasUsuario(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}