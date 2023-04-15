package br.com.htex.hotel.services;

import br.com.htex.hotel.dao.FuncionarioDao;
import br.com.htex.hotel.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioDao funcionarioDao;

    public Funcionario BuscaFuncionarioBy(Integer id){
        return this.funcionarioDao.findById(id).orElseThrow(
                () -> new RuntimeException("Funcionario não encontrado")
        );
    }
}
