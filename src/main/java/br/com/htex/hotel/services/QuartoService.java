package br.com.htex.hotel.services;
import br.com.htex.hotel.dao.QuartoDao;
import br.com.htex.hotel.model.Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {
    @Autowired
    QuartoDao quartoDao;

    public List<Quarto> BuscarQuartosReserva(List<Integer> ids){
        return this.quartoDao.findAll().stream().filter(
                quarto -> ids.contains(quarto.getId())
        ).toList();
    }

    public List<Quarto> listaQuartosDisponivelHotel(Integer id){
        return this.quartoDao.listaQuartosDisponivelHotel(id);
    }

    public void saveAll(List<Quarto> quartosOcupados) {
        this.quartoDao.saveAll(quartosOcupados);
    }
}
