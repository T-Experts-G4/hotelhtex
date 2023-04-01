package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Integer> { }
