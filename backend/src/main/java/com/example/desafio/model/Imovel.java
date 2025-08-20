package com.example.desafio.model;

import com.example.desafio.model.enums.TipoImovel;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "imoveis")
@Data
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoImovel tipo;
    private String bairro;
    private String descricao;

    public Imovel() {
    }

    public Imovel(TipoImovel tipo, String bairro, String descricao) {
        this.tipo = tipo;
        this.bairro = bairro;
        this.descricao = descricao;
    }

   

    
    

    
}
