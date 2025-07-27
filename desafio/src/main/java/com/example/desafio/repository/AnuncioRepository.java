package com.example.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.model.Anuncio;
import com.example.desafio.model.Imovel;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long>{

    boolean existsByImovel(Imovel imovel);

    List<Anuncio> findByCorretorNomeOrImovelBairro(String corretor, String bairro);


    
}
