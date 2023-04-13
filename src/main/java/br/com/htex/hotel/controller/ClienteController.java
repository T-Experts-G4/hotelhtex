package br.com.htex.hotel.controller;

import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.ClienteDto;
import br.com.htex.hotel.model.dto.ClienteOutputDto;
import br.com.htex.hotel.services.ClienteService;
import br.com.htex.hotel.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
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
    public ResponseEntity<List<ClienteOutputDto>> listaClientes() {
        List<ClienteOutputDto> clientesOutputDto = this.clienteService.listaClientes();
        return ResponseEntity.status(200).body(clientesOutputDto);
    }

    @Transactional
    @PostMapping("/cadastra")
    public ResponseEntity<String> cadastra(
            @Valid @RequestBody ClienteDto clienteDto
    ) throws Exception {
        try {
            Optional<Usuario> usuario = this.usuarioService.findById(clienteDto.idUsuario());
            usuario.orElseThrow(() -> new Exception("Usuário não encontrado"));

            usuario.ifPresent(value -> this.clienteService.cadastrarCliente(clienteDto, value));

            return ResponseEntity.status(200).body("Cliente cadastrado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}