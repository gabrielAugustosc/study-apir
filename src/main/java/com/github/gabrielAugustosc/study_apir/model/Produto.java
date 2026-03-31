package com.github.gabrielAugustosc.study_apir.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    private final Long id;
    private final String nome;
    private final BigDecimal valor;

    
    public Produto(Long id, String nome, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }


    
   

    
}