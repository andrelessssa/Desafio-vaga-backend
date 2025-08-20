package com.example.desafio.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.desafio.exception.AnuncioNaoEncontradoException;
import com.example.desafio.exception.CorretorNaoEncontradoException;
import com.example.desafio.exception.ImovelNaoEncontradoException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CorretorNaoEncontradoException.class)
    public ResponseEntity<String> handleCorretorNaoEncontrado(CorretorNaoEncontradoException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

    }
    @ExceptionHandler(AnuncioNaoEncontradoException.class)
    public ResponseEntity<String> handleAnuncioNaoEncontrado(AnuncioNaoEncontradoException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(ImovelNaoEncontradoException.class)
    public ResponseEntity<String> handleImovelNaoEncontrado(ImovelNaoEncontradoException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    
}
