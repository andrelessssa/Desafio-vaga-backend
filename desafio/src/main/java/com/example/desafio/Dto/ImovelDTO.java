package com.example.desafio.Dto;

import com.example.desafio.model.enums.TipoImovel;

public record ImovelDTO(TipoImovel tipo, String bairro, String descricao) {
    
}
