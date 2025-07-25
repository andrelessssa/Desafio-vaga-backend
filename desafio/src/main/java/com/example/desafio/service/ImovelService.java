package com.example.desafio.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.example.desafio.Dto.ImovelDTO;
import com.example.desafio.model.Imovel;
import com.example.desafio.repository.ImovelRepository;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public Imovel criarImovel(ImovelDTO imovelDTO){
        Imovel imovel = new Imovel();
        BeanUtils.copyProperties(imovelDTO, imovel);
        return imovelRepository.save(imovel);
    }
    public List<Imovel> listarImoveis(){
        return imovelRepository.findAll();
    }
    public Imovel buscarImovelPorId(Long id){
        return imovelRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Imovel não encontrado com ID: " + id));
    }
    public Imovel atualizarImovel(Long id, ImovelDTO imovelDTO){
        Imovel imovelAtualizado = buscarImovelPorId(id);
        BeanUtils.copyProperties(imovelDTO, imovelAtualizado, "id");
        return imovelRepository.save(imovelAtualizado);
    }
    public void deletarImovel(Long id){
       Imovel imovel = buscarImovelPorId(id);
       imovelRepository.delete(imovel);
    }

    
}
