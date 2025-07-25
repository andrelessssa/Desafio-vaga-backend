package com.example.desafio.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.desafio.Dto.AnuncioDTO;
import com.example.desafio.Dto.CorretorDTO;
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
    

}
