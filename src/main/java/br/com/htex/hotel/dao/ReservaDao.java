package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDao extends JpaRepository<Reserva, Integer> {

}
