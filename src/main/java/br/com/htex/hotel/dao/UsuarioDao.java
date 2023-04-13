package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {
    Usuario findByEmailAndSenha(String email, String senha);

}