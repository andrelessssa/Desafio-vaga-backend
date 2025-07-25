package com.example.desafio.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.Dto.CorretorDTO;
import com.example.desafio.model.Corretor;
import com.example.desafio.repository.CorretorRepository;

@Service
public class CorretorService {

    @Autowired
    private CorretorRepository corretorRepository;

     public Corretor criarCorretor(CorretorDTO corretorDTO){
        Corretor corretor = new Corretor();
        BeanUtils.copyProperties(corretorDTO, corretor);
        return corretorRepository.save(corretor);

    }

    
}
