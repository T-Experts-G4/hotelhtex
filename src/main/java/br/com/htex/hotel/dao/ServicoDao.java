package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoDao extends JpaRepository<Servico, Integer> {
}
