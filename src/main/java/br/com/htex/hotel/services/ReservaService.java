package br.com.htex.hotel.services;

import br.com.htex.hotel.dao.ReservaDao;
import br.com.htex.hotel.model.*;
import br.com.htex.hotel.model.dto.reserva.ReservaDto;
import br.com.htex.hotel.model.dto.reserva.ReservaFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    ClienteService clienteService;

    @Autowired
    QuartoService quartoService;

    @Autowired
    ServicoService servicoService;

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    ReservaDao reservaDao;

    public List<Reserva> listarReservas(){
        return this.reservaDao.findAll();
    }

    public void cadastraReserva(ReservaFormDto reservaFormDto) {

        List<Quarto> quartos = this.quartoService.BuscarQuartosReserva(reservaFormDto.quartos());

        List<Servico> servicos = this.servicoService.BuscarServicos(reservaFormDto.servicos());

        Funcionario funcionario = this.funcionarioService.BuscaFuncionarioBy(reservaFormDto.idFuncionario());

        ReservaDto reservaDto = new ReservaDto(
                reservaFormDto.checkin(),
                reservaFormDto.checkout(),
                reservaFormDto.status(),
                quartos,
                servicos,
                this.clienteService.findById(reservaFormDto.idCliente()),
                funcionario
        );

        List<Quarto> quartosOcupados = quartos.stream().map(quarto -> {
            quarto.setDisponivel(false);
            return quarto;
        }).toList();

        this.quartoService.saveAll(quartosOcupados);

        this.reservaDao.save(new Reserva(reservaDto));
    }
}
