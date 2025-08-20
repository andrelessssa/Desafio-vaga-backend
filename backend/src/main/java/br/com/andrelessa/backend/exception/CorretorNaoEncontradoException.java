package br.com.andrelessa.backend.exception;

public class CorretorNaoEncontradoException extends RuntimeException {

    public CorretorNaoEncontradoException(Long id){
        super("Corretor com id " + id + " Não encontrado");
    } 
    
}
