package com.juliano.desafio_tecnico.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoupaDto {
    private Long id;
    private String nomeMedida;
    private Double valorDimensao;
    private String unidadeMedida;

}
