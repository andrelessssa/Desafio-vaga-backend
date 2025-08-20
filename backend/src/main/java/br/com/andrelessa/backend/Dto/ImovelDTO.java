package br.com.andrelessa.backend.Dto;

import br.com.andrelessa.backend.model.enums.TipoImovel;

public record ImovelDTO(Long id, TipoImovel tipo, String bairro, String descricao) {
    
}
