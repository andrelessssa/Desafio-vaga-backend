package com.example.desafio.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.desafio.exception.CorretorNaoEncontradoException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<String> handleCorretorNaoEncontrado(CorretorNaoEncontradoException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

    }
    
}
