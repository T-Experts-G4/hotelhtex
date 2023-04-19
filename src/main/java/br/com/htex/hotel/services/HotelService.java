package br.com.htex.hotel.services;

import br.com.htex.hotel.dao.HotelDao;
import br.com.htex.hotel.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    HotelDao hotelDao;

    public Hotel listaHotel(Integer id){
        return this.hotelDao.findById(id).orElseThrow(
                () -> new RuntimeException("Hotel não encontrado")
        );
    }
}
