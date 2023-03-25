package br.com.htex.hotel.controller;

import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
//@RestController("/")
@RequestMapping("/")
@Controller
public class ListaController {
    @GetMapping("/listaUsuarios")
    public String listaUsuarios(Model model) {
        Usuario u1 = new Usuario(1,"Silvio", "andeson");
        Usuario u2 = new Usuario(1,"Silvio", "andeson");
        Usuario u3 = new Usuario(1,"Silvio", "andeson");
        Usuario u4 = new Usuario(1,"Silvio", "andeson");

        model.addAttribute("usuarios", Arrays.asList(u1, u2, u3, u4));
        System.out.println(model.toString());

        return "listaUsuarios";
    }
    @GetMapping("/listaClientes")
    public String listaClientes(Model model) {
        model.addAttribute(
                "clientes",
            Arrays.asList(
                new Cliente(1, "Adriano","12345678901", new Usuario("adriano","1234")),
                new Cliente(2, "Silvo","10987654321", new Usuario("silvio","4321")),
                new Cliente(3, "Anderson","45678901234", new Usuario("anderson","3224"))
            )
        );
        return "listaClientes";
    }
}
