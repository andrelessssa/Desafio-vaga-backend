package com.example.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.model.Anuncio;
import com.example.desafio.model.Imovel;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long>{

    boolean existsByImovel(Imovel imovel);
    
}
