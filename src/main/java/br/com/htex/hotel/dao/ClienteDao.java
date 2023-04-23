package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByUsuario(Usuario usuario);

    @Query( value = """
            SELECT c.id, c.cpf, c.nome, c.telefone, c.endereco_id, c.usuario_id
            FROM clientes c, usuarios u
            WHERE c.usuario_id = u.id AND u.USUARIO_ROLE = 'USUARIO'
            """, nativeQuery = true)
    List<Cliente> findAllByCliente();
    @Query( value = """
        SELECT * FROM clientes WHERE usuario_id = :id
            """, nativeQuery = true)
    Optional<Cliente> clienteByUsuario(@Param("id") Integer id);
}