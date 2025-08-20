package br.com.andrelessa.backend.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.andrelessa.backend.Dto.AnuncioDTO;
import br.com.andrelessa.backend.model.Anuncio;



@Mapper(componentModel = "spring")
public interface AnuncioMapper {

    @Mapping(source = "imovel.id", target = "idImovel")
    @Mapping(source = "corretor.id", target = "idCorretor")
    @Mapping(source = "corretor.nome", target = "nomeCorretor")
    @Mapping(source = "imovel.tipo", target = "tipoImovel")
    @Mapping(source = "imovel.bairro", target = "bairro")
    AnuncioDTO toDTO(Anuncio anuncio);
    
}
