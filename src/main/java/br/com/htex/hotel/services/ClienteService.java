package br.com.htex.hotel.services;

import br.com.htex.hotel.dao.ClienteDao;
import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Endereco;
import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.ClienteDto;
import br.com.htex.hotel.model.dto.ClienteOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ClienteService {

    @Autowired
    ClienteDao clienteDao;

    public List<ClienteOutputDto> listaClientes() {
        return this.clienteDao.findAll().stream().map(ClienteOutputDto::new).toList();
    }

    public Optional<Cliente> findByUsuario(Usuario usuario){
        return this.clienteDao.findByUsuario(usuario);
    }

    public void save(Cliente cliente){
        this.clienteDao.save(cliente);
    }

    public void cadastrarCliente(@Valid ClienteDto clienteDto, Usuario usuario){
        Optional<Cliente> cliente = this.findByUsuario(usuario);

//            cliente = Optional.of(new Cliente(
//                    clienteDto.email(),
//                    clienteDto.cpf(),
//                    usuario
//            ));

//        cliente.ifPresentOrElse(
//                value -> value.Update(
//                        clienteDto.email(),
//                        clienteDto.cpf(),
//                        usuario
//                ),
//                () -> new Cliente(
//                        clienteDto.email(),
//                        clienteDto.cpf(),
//                        usuario
//                )
//        );

        if(cliente.isEmpty()){
            cliente = Optional.of(new Cliente(
                    clienteDto.nome(),
                    clienteDto.cpf(),
                    "35345345435",
                    new Endereco(),
                    usuario
            ));
        } else {
            cliente.get().Update(
                    clienteDto.nome(),
                    clienteDto.cpf(),
                    usuario
            );
        }
        this.clienteDao.save(cliente.get());
    }
}