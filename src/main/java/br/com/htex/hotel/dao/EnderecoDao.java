package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoDao extends JpaRepository<Endereco, Integer> {
}
