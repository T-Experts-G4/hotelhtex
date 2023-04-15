package br.com.htex.hotel.model.dto.quarto;
import br.com.htex.hotel.model.Quarto;

import java.math.BigDecimal;

public record QuartoDto(
        Integer id,
        Integer numero,
        BigDecimal preco,
        Boolean disponivel,
        Integer idHotel
) {
    public QuartoDto(Quarto quarto) {
        this(
                quarto.getId(),
                quarto.getNumero(),
                quarto.getPreco(),
                quarto.getDisponivel(),
                quarto.getHotel().getId());
    }
}
