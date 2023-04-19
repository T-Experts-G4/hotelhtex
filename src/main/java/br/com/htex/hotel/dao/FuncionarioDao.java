package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Funcionario;
import br.com.htex.hotel.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioDao extends JpaRepository<Funcionario, Integer> {
    Optional<Funcionario> findByUsuario(Usuario usuario);
}
