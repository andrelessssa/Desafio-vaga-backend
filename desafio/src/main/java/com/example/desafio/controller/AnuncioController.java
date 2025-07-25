package com.example.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.Dto.AnuncioDTO;
import com.example.desafio.model.Anuncio;
import com.example.desafio.service.AnuncioService;

@RestController
@RequestMapping("/anuncio")
public class AnuncioController {

    @Autowired
    private AnuncioService anuncioService;

    @PostMapping
    public ResponseEntity<Anuncio> criarAnuncio(@Valid @RequestBody AnuncioDTO anuncioDTO ){
        Anuncio anuncioCriado = anuncioService.criarAnuncio(anuncioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(anuncioCriado);

    }
    
}
