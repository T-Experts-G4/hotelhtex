package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByUsuario(Usuario usuario);
}