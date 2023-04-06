package br.com.htex.hotel.controller;

import br.com.htex.hotel.dao.ClienteDao;
import br.com.htex.hotel.dao.UsuarioDao;
import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.UsuarioFormInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/listaUsuarios")
    public String listaUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioDao.findAll());
        return "listaUsuarios";
    }

    @GetMapping("/{id}")
    public String mostrarUsuario(
            @PathVariable Integer id,
            Model model
    ){
        try {
            Usuario usuario = usuarioDao.findById(id).get();

            Cliente cliente = this.clienteDao.findByUsuario(usuario);
            if (cliente == null){
                cliente = new Cliente(usuario);
            }

            model.addAttribute("cliente", cliente);
            return "usuario/detalheUsuario";
        } catch (Exception e){
            return "redirect:/login";
        }
    }

    @GetMapping("/formUsuario")
    public String form(Model model, UsuarioFormInputDto usuarioFormInputDto){
        model.addAttribute("usuarioFormInputDto",usuarioFormInputDto);
        return "formusuario";
    }

    @Transactional
    @PostMapping("/cadastra")
    public String cadastra(
            @Valid UsuarioFormInputDto usuarioFormInputDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model
    ){
        if(bindingResult.hasErrors()){
            bindingResult.getFieldErrors().forEach(campoErro -> System.out.println(campoErro.getDefaultMessage()));
            return form(model, usuarioFormInputDto);
        }

        Usuario usuario = usuarioFormInputDto.toUsuario();

        usuarioDao.save(usuario);
        redirectAttributes.addFlashAttribute("sucesso","usuário cadastrado com sucesso!");
        return "redirect:/usuario/listaUsuarios";
    }
}