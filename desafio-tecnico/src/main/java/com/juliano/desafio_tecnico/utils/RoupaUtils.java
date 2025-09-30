package com.juliano.desafio_tecnico.utils;

import org.springframework.stereotype.Component;

import com.juliano.desafio_tecnico.dto.RoupaDto;
import com.juliano.desafio_tecnico.model.Roupa;

@Component
public class RoupaUtils{
    
    public RoupaDto convertEntityToDto(Roupa roupa){

        return RoupaDto.builder()
                .id(roupa.getId())
                .nomeMedida(roupa.getNomeMedida())
                .valorDimensao(roupa.getValorDimensao())
                .unidadeMedida(roupa.getUnidadeMedida())
                .build();

    }

    public Roupa convertDtoToEntity(RoupaDto roupaDto){

        return Roupa.builder()
                .id(roupaDto.getId())
                .nomeMedida(roupaDto.getNomeMedida())
                .valorDimensao(roupaDto.getValorDimensao())
                .unidadeMedida(roupaDto.getUnidadeMedida())
                .build();

    }
}
