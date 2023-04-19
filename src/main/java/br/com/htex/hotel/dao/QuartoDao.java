package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuartoDao extends JpaRepository<Quarto, Integer> {

    @Query(value = "SELECT * FROM quartos WHERE disponivel = true", nativeQuery = true)
    List<Quarto> listaQuartosDisponivel();

    @Query(
            value = "SELECT * FROM QUARTOS WHERE HOTEL_ID = :id AND DISPONIVEL = true",
            nativeQuery = true
    )
    List<Quarto> listaQuartosDisponivelHotel(@Param("id") Integer id);
}