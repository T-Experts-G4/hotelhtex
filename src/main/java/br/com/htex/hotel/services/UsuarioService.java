package br.com.htex.hotel.services;

import br.com.htex.hotel.dao.UsuarioDao;
import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.FormUsuarioLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioDao usuarioDao;

    public Usuario autentica(FormUsuarioLoginDto formUsuarioLoginDto){

        return this.usuarioDao.findByNomeAndSenha(
                formUsuarioLoginDto.nome(),
                formUsuarioLoginDto.senha()
        );
    }

    public Optional<Usuario> findById(Integer Id){
        return this.usuarioDao.findById(Id);
    }
}