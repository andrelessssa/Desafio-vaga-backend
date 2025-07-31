package com.example.desafio.exception;

public class CorretorNaoEncontradoException extends RuntimeException {

    public CorretorNaoEncontradoException(Long id){
        super("Corretor com id " + id + " Não encontrado");
    } 
    
}
