package com.example.desafio.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.desafio.Dto.AnuncioDTO;
import com.example.desafio.model.Anuncio;

@Mapper(componentModel = "spring")
public interface AnuncioMapper {

    @Mapping(source = "imovel.id", target = "idImovel")
    @Mapping(source = "corretor.id", target = "idCorretor")
    AnuncioDTO toDTO(Anuncio anuncio);

    
}
