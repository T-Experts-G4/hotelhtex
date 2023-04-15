package br.com.htex.hotel.controller;

import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.FormUsuarioLoginDto;
import br.com.htex.hotel.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody FormUsuarioLoginDto formUsuarioLogin
    ){
        try {
            Usuario usuario = this.usuarioService.autentica(formUsuarioLogin);
            return ResponseEntity.ok(usuario);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}