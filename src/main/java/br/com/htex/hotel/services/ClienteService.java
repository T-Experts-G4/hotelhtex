package br.com.htex.hotel.services;

import br.com.htex.hotel.dao.ClienteDao;
import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.ClienteDto;
import br.com.htex.hotel.model.dto.ClienteOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteDao clienteDao;

    public List<ClienteOutputDto> listaClientes() {
        return this.clienteDao.findAll().stream().map(ClienteOutputDto::new).toList();
    }

    public void save(Cliente cliente){
        this.clienteDao.save(cliente);
    }

    public void cadastrarCliente(@Valid ClienteDto clienteDto, Usuario usuario){

        Cliente cliente = this.clienteDao.findByUsuario(usuario);

        if(cliente == null){
            cliente = new Cliente(
                    clienteDto.nome(),
                    clienteDto.cpf(),
                    usuario
            );

        } else {
            cliente.Update(
                    clienteDto.nome(),
                    clienteDto.cpf(),
                    usuario
            );
        }

        this.clienteDao.save(cliente);
    }
    public void deleta(Integer id){
        this.clienteDao.deleteById(id);
    }
}