package br.com.htex.hotel.services;

import br.com.htex.hotel.dao.EnderecoDao;
import br.com.htex.hotel.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServico {
    @Autowired
    EnderecoDao enderecoDao;

    public void save(Endereco endereco){
        this.enderecoDao.save(endereco);
    }
}
