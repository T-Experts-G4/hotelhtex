package br.com.htex.hotel.controller;

import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.ClienteDto;
import br.com.htex.hotel.model.dto.ClienteOutputDto;
import br.com.htex.hotel.model.dto.FuncionarioDto;
import br.com.htex.hotel.services.ClienteService;
import br.com.htex.hotel.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listaClientes")
    public ResponseEntity<?> listaClientes(
            @RequestBody ClienteDto clienteDto
    ) {
        try {
            Usuario usuario = this.usuarioService.findById(clienteDto.idUsuario());

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
            Usuario usuario = this.usuarioService.findById(clienteDto.idUsuario());

            this.clienteService.cadastrarCliente(clienteDto, usuario);

            return ResponseEntity.status(200).body("Cliente cadastrado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}