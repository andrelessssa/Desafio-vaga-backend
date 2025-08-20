package br.com.andrelessa.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andrelessa.backend.model.Corretor;



public interface CorretorRepository extends JpaRepository<Corretor, Long> {
    
}
