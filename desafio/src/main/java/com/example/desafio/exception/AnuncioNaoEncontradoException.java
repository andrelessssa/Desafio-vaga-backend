package com.example.desafio.exception;


public class AnuncioNaoEncontradoException extends RuntimeException{

    public AnuncioNaoEncontradoException(Long id){
        super("Anuncio com id " + id + " Não encontrado");
    } 
    
}
