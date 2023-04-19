package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservaDao extends JpaRepository<Reserva, Integer> {
    @Query(value = """
            SELECT
            R.ID,
            R.CHECKIN,
            R.CHECKOUT,
            R.DATA,
            R.STATUS_PAGO,
            R.CLIENTE_ID,
            R.FUNCIONARIO_ID,
            R.CANCELADA
            FROM RESERVAS R JOIN CLIENTES 
            WHERE CLIENTES.USUARIO_ID = :id AND R.CANCELADA = false
            """, nativeQuery = true)
    List<Reserva> findByUsuario(@Param("id") Integer id);
}
