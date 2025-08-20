package com.example.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.model.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long>{
    
}
