
package com.github.gabrielAugustosc.study_apir.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data

@Table(name = "clientes")

public class Cliente {
    @Id

    private long id;
    @Column(name = "nome_cliente", length = 100, nullable = false)
    private String nome;


   

    public Cliente(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    

}