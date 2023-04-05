package br.com.htex.hotel.dao;

import br.com.htex.hotel.model.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsuarioDao {

    public List<Usuario> lista(){
        return this.entityManager.createQuery("select u from Usuario u",Usuario.class).getResultList();
    }

    @PersistenceContext
    private EntityManager entityManager;
    public void cadastra(Usuario usuario){
        this.entityManager.persist(usuario);
    }

    public Usuario buscaPor(Integer id){
        return this.entityManager.find(Usuario.class, id);
    }

    public void deleta(Integer id){
        Usuario usuario = this.entityManager.find(Usuario.class,id);
        this.entityManager.remove(usuario);
    }
}
