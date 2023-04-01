package br.com.htex.hotel.controller;

import br.com.htex.hotel.dao.UsuarioDao;
import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.UsuarioDetalheOutputDto;
import br.com.htex.hotel.model.dto.UsuarioFormInputDto;
import br.com.htex.hotel.model.dto.UsuarioOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioDao dao;
    /*
    e /detalhe
     */
    @GetMapping("/form")
    public String form(Model model, UsuarioFormInputDto usuarioFormInputDto){
        model.addAttribute("usuarioFormInputDto",usuarioFormInputDto);
        return "formusuario";
    }
    @Transactional
    @PostMapping("/cadastra")
    public String cadastra(@Valid UsuarioFormInputDto usuarioFormInputDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            bindingResult.getFieldErrors().forEach(campoErro -> System.out.println(campoErro.getDefaultMessage()));
            return form(model, usuarioFormInputDto);
        }
        Usuario usuario = usuarioFormInputDto.toUsuario();
        this.dao.cadastra(usuario);
        redirectAttributes.addFlashAttribute("sucesso","usuário cadastrado com sucesso!");
        return "redirect:/usuario/lista";
    }

    @GetMapping("/lista")
    public String lista(Model model){
        List<UsuarioOutputDto> usuariosDto = dao.lista().stream().map(usuario -> new UsuarioOutputDto(usuario)).collect(Collectors.toList());
        model.addAttribute("usuarios",usuariosDto);
        return "listaUsuarios";
    }

    @GetMapping("/detalhe")
    public String detalhe(@RequestParam("id") Integer id, Model model){

        model.addAttribute("usuario",new UsuarioDetalheOutputDto(this.dao.buscaPor(id)));
        return "index";
    }

}
