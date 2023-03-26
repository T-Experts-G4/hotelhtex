package br.com.htex.hotel.controller;

import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
@Controller
@RequestMapping("/hotel")
public class ListaController {
    @GetMapping("/listaUsuarios")
    public String listaUsuarios(Model model) {
        model.addAttribute("usuarios",
                Arrays.asList(
                        new Usuario(1,"adriano", "1234"),
                        new Usuario(1,"silvio", "4321"),
                        new Usuario(1,"andeson", "3224"))
        );
        return "listaUsuarios";
    }
    @GetMapping("/listaClientes")
    public String listaClientes(Model model) {
        model.addAttribute("clientes",
            Arrays.asList(
                new Cliente(1, "Adriano","12345678901", new Usuario("adriano","1234")),
                new Cliente(2, "Silvo","10987654321", new Usuario("silvio","4321")),
                new Cliente(3, "Anderson","45678901234", new Usuario("anderson","3224"))
            )
        );
        return "listaClientes";
    }
}
