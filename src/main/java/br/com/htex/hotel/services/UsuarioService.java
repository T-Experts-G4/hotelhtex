package br.com.htex.hotel.services;

import br.com.htex.hotel.dao.UsuarioDao;
import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.FormUsuarioLoginDto;
import br.com.htex.hotel.model.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioDao usuarioDao;

    public Usuario autentica(FormUsuarioLoginDto formUsuarioLoginDto){

        return this.usuarioDao.findByEmailAndSenha(
                formUsuarioLoginDto.email(),
                formUsuarioLoginDto.senha()
        );
    }

    public List<UsuarioDto> listaUsuariosDto(){
        return this.usuarioDao.findAll().stream().map(UsuarioDto::new).toList();
    }

    public Optional<Usuario> findById(Integer Id){
        return this.usuarioDao.findById(Id);
    }

    public Usuario save(Usuario usuario){
        return this.usuarioDao.save(usuario);
    }

}