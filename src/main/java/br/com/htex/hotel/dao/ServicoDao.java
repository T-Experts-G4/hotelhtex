package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicoDao extends JpaRepository<Servico, Integer> {
    @Query(value = "select * from servicos where id > 1", nativeQuery = true)
    List<Servico> findByServicos();
}
