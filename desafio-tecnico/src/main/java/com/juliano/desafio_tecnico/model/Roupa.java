package com.juliano.desafio_tecnico.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roupas")
public class Roupa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeMedida;
    private Double valorDimensao;
    private String unidadeMedida;
}
