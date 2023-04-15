package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelDao extends JpaRepository<Hotel, Integer> {
}
