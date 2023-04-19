package br.com.htex.hotel.services;

import br.com.htex.hotel.dao.UsuarioDao;
import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.FormUsuarioLoginDto;
import br.com.htex.hotel.model.dto.usuario.UsuarioDto;
import br.com.htex.hotel.model.dto.usuario.UsuarioFormInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    FuncionarioService funcionarioService;

    public Usuario autentica(FormUsuarioLoginDto formUsuarioLoginDto){

        return this.usuarioDao.findByEmailAndSenha(
                formUsuarioLoginDto.email(),
                formUsuarioLoginDto.senha()
        ).orElseThrow(() -> new RuntimeException("Credentials invalids"));
    }

    public List<UsuarioDto> listaUsuariosDto(){
        return this.usuarioDao.findAll().stream().map(UsuarioDto::new).toList();
    }

    public Usuario findById(Integer Id){
        return this.usuarioDao.findById(Id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
    }

    public Usuario save(@Valid UsuarioFormInputDto usuario){

        UsuarioRoles usuarioRole = UsuarioRoles.USUARIO;

        Usuario usuarioS = new Usuario(
                usuario.email(),
                usuario.senha(),
                usuarioRole.getRole()
        );

        return this.usuarioDao.save(usuarioS);
    }

    public void save(Usuario usuario){
        this.usuarioDao.save(usuario);
    }

}