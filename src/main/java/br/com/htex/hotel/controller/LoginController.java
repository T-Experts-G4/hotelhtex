package br.com.htex.hotel.controller;

import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.FormUsuarioLoginDto;
import br.com.htex.hotel.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/login")
    public String login(){
        return "login/login";
    }

    @RequestMapping("/login/auth")
    public String auth(
            FormUsuarioLoginDto formUsuarioLogin,
            Model model
    ){
        Usuario usuario = this.usuarioService.autentica(formUsuarioLogin);
        if (usuario == null){
            return "redirect:/login";
        }

        model.addAttribute("usuario", usuario);
        return "redirect:/usuario/" + usuario.getId();
    }
}