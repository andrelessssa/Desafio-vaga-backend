package com.example.desafio.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.Dto.CorretorDTO;
import com.example.desafio.model.Corretor;
import com.example.desafio.service.CorretorService;

@RestController
@RequestMapping(value = "/corretor")
public class CorretorController {

    @Autowired
    private CorretorService corretorService;

    @PostMapping
    public ResponseEntity<Corretor> criarCorretor(@RequestBody CorretorDTO corretorDTO){
        Corretor corretorCriado = corretorService.criarCorretor(corretorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(corretorCriado);

    }

   

    
}
