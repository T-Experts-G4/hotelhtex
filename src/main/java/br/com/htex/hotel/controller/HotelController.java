package br.com.htex.hotel.controller;

import br.com.htex.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotel")
@Transactional
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping("/{id}")
    public ResponseEntity<?> listaHoteis(
            @PathVariable Integer id
    ){
        try {
            return ResponseEntity.ok(this.hotelService.listaHotel(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}