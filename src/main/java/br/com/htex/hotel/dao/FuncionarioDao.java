package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioDao extends JpaRepository<Funcionario, Integer> {

}
