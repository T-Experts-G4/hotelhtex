package br.com.htex.hotel.controller;

import br.com.htex.hotel.dao.ClienteDao;
import br.com.htex.hotel.dao.UsuarioDao;
import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.ClienteFormInputDto;
import br.com.htex.hotel.model.dto.UsuarioFormInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteDao clienteDao;
    @Autowired
    UsuarioDao usuarioDao;

    @GetMapping("/listaClientes")
    public String listaClientes(Model model) {
        model.addAttribute("clientes", clienteDao.findAll());
        return "listaClientes";
    }

    @GetMapping("/formCliente")
    public String form(Model model, ClienteFormInputDto clienteFormInputDto){
        model.addAttribute(clienteFormInputDto);
        return "formcliente";
    }
    @Transactional
    @PostMapping("/cadastra")
    public String cadastra(@Valid ClienteFormInputDto clienteFormInputDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            bindingResult.getFieldErrors().forEach(campoErro -> System.out.println(campoErro.getDefaultMessage()));
            return form(model, clienteFormInputDto.toCliente());
        }
        Optional<Usuario> usuario = usuarioDao.findById(clienteFormInputDto.getidUsuario());
        Cliente cliente = new Cliente(clienteFormInputDto.getNome(),clienteFormInputDto.getCpf(),usuario.get());
        clienteDao.save(cliente);
        redirectAttributes.addFlashAttribute("sucesso","cliente cadastrado com sucesso!");
        return "redirect:/cliente/listaClientes";
    }
}
