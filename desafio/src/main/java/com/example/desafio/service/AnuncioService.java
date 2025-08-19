package com.example.desafio.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.desafio.Dto.AnuncioDTO;
import com.example.desafio.Dto.AtualizacaoAnuncioDTO;
import com.example.desafio.mappers.AnuncioMapper;
import com.example.desafio.model.Anuncio;
import com.example.desafio.model.Corretor;
import com.example.desafio.model.Imovel;
import com.example.desafio.repository.AnuncioRepository;
import com.example.desafio.repository.CorretorRepository;
import com.example.desafio.repository.ImovelRepository;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;
    @Autowired
    private CorretorRepository corretorRepository;
    @Autowired
    private ImovelRepository imovelRepository;
    @Autowired
    private AnuncioMapper anuncioMapper;


    public Anuncio criarAnuncio(AnuncioDTO DTO){
        Imovel imovel = imovelRepository.findById(DTO.idImovel())
        .orElseThrow(() -> new RuntimeException("Imóvel não encontrado"));

        Corretor corretor = corretorRepository.findById(DTO.idCorretor())
        .orElseThrow(() -> new RuntimeException("Corretor não encontrado") );

        if (anuncioRepository.existsByImovel(imovel)) {
        throw new RuntimeException("Este imóvel já possui um anúncio.");
    }

        Anuncio anuncioCriado = new Anuncio(imovel, corretor);
        return anuncioRepository.save(anuncioCriado);   
    }
    public List<Anuncio> listarAnuncios(){
        return anuncioRepository.findAll();
    }
    public Anuncio buscarAnuncioPorId(Long id){
        return anuncioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException( "Anúncio não encontrado com ID: " + id));
    }  
    
    public Anuncio atualizarAnuncio(Long id , AtualizacaoAnuncioDTO atualizacaoAnuncioDTO){
        Anuncio anuncioAtual = buscarAnuncioPorId(id);

        Imovel imovel = imovelRepository.findById(atualizacaoAnuncioDTO.idImovel())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imóvel não encontrado"));

        Corretor corretor = corretorRepository.findById(atualizacaoAnuncioDTO.idCorretor())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Corretor não encontrado"));

        anuncioAtual.setImovel(imovel);
        anuncioAtual.setCorretor(corretor);

        return anuncioRepository.save(anuncioAtual);
    }
    public void deletarAnuncio(Long id){
        Anuncio anuncio = buscarAnuncioPorId(id);
        anuncioRepository.delete(anuncio);
    }  
    
    //----------Filtro de anúncios por nome do corretor ou bairro do imóvel----------//

    public List<AnuncioDTO> BuscarPorCorretorOuBairro(String corretor, String bairro){
        List<Anuncio> resultado = anuncioRepository.findByCorretorNomeOrImovelBairro(corretor, bairro);
        return resultado.stream().map(anuncioMapper::toDTO).collect(Collectors.toList());

    }

}
