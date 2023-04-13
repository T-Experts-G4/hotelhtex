package br.com.htex.hotel.controller;

import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.UsuarioClienteDto;
import br.com.htex.hotel.model.dto.UsuarioDto;
import br.com.htex.hotel.model.dto.UsuarioFormInputDto;
import br.com.htex.hotel.services.ClienteService;
import br.com.htex.hotel.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listaUsuarios")
    public ResponseEntity<List<UsuarioDto>> listaUsuarios() {
        List<UsuarioDto> listaUsuariosDto = this.usuarioService.listaUsuariosDto();

        return ResponseEntity.status(200).body(listaUsuariosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarUsuario(
            @PathVariable Integer id
    ) throws Exception {
        try {
            Optional<Usuario> usuario = this.usuarioService.findById(id);
            usuario.orElseThrow(() -> new Exception("Usuário não encontrado"));

            Optional<Cliente> cliente = this.clienteService.findByUsuario(usuario.get());

            UsuarioClienteDto usuarioClienteDto = new UsuarioClienteDto(
                    cliente.orElse(new Cliente(usuario.get()))
            );

            return ResponseEntity.status(200).body(usuarioClienteDto);
        } catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @Transactional
    @PostMapping("/cadastra")
    public ResponseEntity<UsuarioDto> cadastra(
            @Valid @RequestBody UsuarioFormInputDto usuarioFormInputDto
    ){
        Usuario usuario = new Usuario(usuarioFormInputDto);

        UsuarioDto usuarioDto = new UsuarioDto(this.usuarioService.save(usuario));

        return ResponseEntity.status(201).body(usuarioDto);
    }
}