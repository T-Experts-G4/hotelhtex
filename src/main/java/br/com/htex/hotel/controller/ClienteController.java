package br.com.htex.hotel.controller;

import br.com.htex.hotel.dao.ClienteDao;
import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.ClienteOutputDto;
import br.com.htex.hotel.model.dto.ClienteDto;
import br.com.htex.hotel.services.ClienteService;
import br.com.htex.hotel.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String listaClientes(Model model) {
        List<ClienteOutputDto> clienteOutputDto = this.clienteService.listaClientes();
        model.addAttribute("clientes", clienteOutputDto);
        return "listaClientes";

    }

    @GetMapping("/formCliente")
    public String form(Model model, ClienteDto clienteFormInputDto){
        model.addAttribute(clienteFormInputDto);
        return "formcliente";
    }

    @Transactional
    @PostMapping("/cadastra")
    public String cadastra(
            @Valid ClienteDto clienteDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model
    ){
        if(bindingResult.hasErrors()){
            bindingResult.getFieldErrors().forEach(campoErro -> System.out.println(campoErro.getDefaultMessage()));
            return form(model, clienteDto.toCliente());
        }

        Optional<Usuario> usuario = this.usuarioService.findById(clienteDto.idUsuario());

        usuario.ifPresent(value -> this.clienteService.cadastrarCliente(clienteDto, value));

        redirectAttributes.addFlashAttribute("sucesso","cliente cadastrado com sucesso!");

        return "redirect:/usuario/" + clienteDto.idUsuario();
    }

    @GetMapping("/deleta/{id}")
    public String deleta(@PathVariable Integer id) {
        this.clienteService.deleta(id);
        return "redirect:/cliente/listaClientes";
    }
}