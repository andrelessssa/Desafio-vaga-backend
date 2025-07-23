package com.example.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.model.Corretor;

public interface CorretorRepository extends JpaRepository<Corretor, Long> {
    
}
