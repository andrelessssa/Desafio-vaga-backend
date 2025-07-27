package com.example.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.Dto.AnuncioDTO;
import com.example.desafio.Dto.AtualizacaoAnuncioDTO;
import com.example.desafio.model.Anuncio;

import com.example.desafio.service.AnuncioService;

import jakarta.validation.Valid;

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
    @GetMapping
    public ResponseEntity<List<Anuncio>> listarAnuncios(){
        return ResponseEntity.ok(anuncioService.listarAnuncios());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Anuncio> buscarAnuncioPorId(@PathVariable Long id){
        return ResponseEntity.ok(anuncioService.buscarAnuncioPorId(id));

    }
    @PatchMapping("/{id}")
    public ResponseEntity<Anuncio> atualizarAnuncio(@PathVariable Long id, @RequestBody AtualizacaoAnuncioDTO atualizacaoAnuncioDTO){

        Anuncio anuncioAtual = anuncioService.atualizarAnuncio(id, atualizacaoAnuncioDTO);
        return ResponseEntity.ok(anuncioAtual);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAnuncio(@PathVariable Long id){
        anuncioService.deletarAnuncio(id);
        return ResponseEntity.status(HttpStatus.OK).body("Anuncio Deletado");
    }

    //----------Filtro de anúncios por nome do corretor ou bairro do imóvel----------//

    @GetMapping("/buscar")
    public ResponseEntity<List<AnuncioDTO>> BuscarPorCorretorOuBairro(@RequestParam(required = false) String corretor, @RequestParam(required = false) String bairro){
        List<AnuncioDTO> anuncioDTOs = anuncioService.BuscarPorCorretorOuBairro(corretor, bairro);
        return ResponseEntity.ok(anuncioDTOs);

    } 

    
}
