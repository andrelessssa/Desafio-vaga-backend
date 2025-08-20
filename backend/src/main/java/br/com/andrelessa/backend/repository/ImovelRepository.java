package br.com.andrelessa.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andrelessa.backend.model.Imovel;



public interface ImovelRepository extends JpaRepository<Imovel, Long>{
    
}
