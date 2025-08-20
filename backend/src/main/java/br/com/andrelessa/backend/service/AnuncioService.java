package br.com.andrelessa.backend.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import br.com.andrelessa.backend.Dto.AnuncioDTO;
import br.com.andrelessa.backend.Dto.AtualizacaoAnuncioDTO;
import br.com.andrelessa.backend.exception.AnuncioNaoEncontradoException;
import br.com.andrelessa.backend.exception.CorretorNaoEncontradoException;
import br.com.andrelessa.backend.exception.ImovelNaoEncontradoException;
import br.com.andrelessa.backend.mappers.AnuncioMapper;
import br.com.andrelessa.backend.model.Anuncio;
import br.com.andrelessa.backend.model.Corretor;
import br.com.andrelessa.backend.model.Imovel;
import br.com.andrelessa.backend.repository.AnuncioRepository;
import br.com.andrelessa.backend.repository.CorretorRepository;
import br.com.andrelessa.backend.repository.ImovelRepository;



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
        .orElseThrow(() -> new AnuncioNaoEncontradoException(id));
    } 
    
    public Anuncio atualizarAnuncio(Long id , AtualizacaoAnuncioDTO atualizacaoAnuncioDTO){
        Anuncio anuncioAtual = buscarAnuncioPorId(id);

        Imovel imovel = imovelRepository.findById(atualizacaoAnuncioDTO.idImovel())
        .orElseThrow(() -> new ImovelNaoEncontradoException(id));

        Corretor corretor = corretorRepository.findById(atualizacaoAnuncioDTO.idCorretor())
        .orElseThrow(() -> new CorretorNaoEncontradoException(id));

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
