package br.com.andrelessa.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andrelessa.backend.model.Anuncio;
import br.com.andrelessa.backend.model.Imovel;


public interface AnuncioRepository extends JpaRepository<Anuncio, Long>{

    boolean existsByImovel(Imovel imovel);

    List<Anuncio> findByCorretorNomeOrImovelBairro(String corretor, String bairro);


    
}
