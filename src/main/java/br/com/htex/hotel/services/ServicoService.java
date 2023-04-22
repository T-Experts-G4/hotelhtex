package br.com.htex.hotel.services;

import br.com.htex.hotel.dao.ServicoDao;
import br.com.htex.hotel.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {
    @Autowired
    ServicoDao servicoDao;

    public List<Servico> buscarServicos(List<Integer> ids){
        return this.servicoDao.findAll().stream().filter(
                servico -> ids.contains(servico.getId())
        ).toList();
    }

    public List<Servico> buscarServicos(){
        return this.servicoDao.findByServicos();
    }
}
