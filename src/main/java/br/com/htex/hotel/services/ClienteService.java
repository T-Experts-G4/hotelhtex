package br.com.htex.hotel.services;

import br.com.htex.hotel.dao.ClienteDao;
import br.com.htex.hotel.model.Cliente;
import br.com.htex.hotel.model.Endereco;
import br.com.htex.hotel.model.Usuario;
import br.com.htex.hotel.model.dto.ClienteDto;
import br.com.htex.hotel.model.dto.ClienteOutputDto;
import br.com.htex.hotel.model.dto.FuncionarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Autowired
    EnderecoServico enderecoServico;

    public List<ClienteOutputDto> listaClientes(Usuario usuario) {

        if(usuario.getUsuarioRole().equals("ADMIN")){
            return this.clienteDao.findAllByCliente().stream().map(ClienteOutputDto::new).toList();
        }

        throw new RuntimeException("Acesso negado");
    }

    public Optional<Cliente> findByUsuario(Usuario usuario){
        return this.clienteDao.findByUsuario(usuario);
    }

    public Cliente findById(Integer id){
        return this.clienteDao.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void save(Cliente cliente){
        this.clienteDao.save(cliente);
    }

    public void cadastrarCliente(@Valid ClienteDto clienteDto, Usuario usuario){
        Optional<Cliente> cliente = this.findByUsuario(usuario);
        Endereco endereco = new Endereco(
                clienteDto.endereco().getCep(),
                clienteDto.endereco().getLogradouro(),
                clienteDto.endereco().getComplemento(),
                clienteDto.endereco().getBairro(),
                clienteDto.endereco().getLocalidade(),
                clienteDto.endereco().getUf()
        );

        if(cliente.isEmpty()){
            cliente = Optional.of(new Cliente(
                    clienteDto.nome(),
                    clienteDto.cpf(),
                    clienteDto.telefone(),
                    endereco,
                    usuario
            ));
        } else {
            cliente.get().Update(
                    clienteDto.nome(),
                    clienteDto.cpf(),
                    usuario,
                    clienteDto.telefone(),
                    endereco
            );
        }

        this.enderecoServico.save(endereco);
        this.clienteDao.save(cliente.get());
    }
}