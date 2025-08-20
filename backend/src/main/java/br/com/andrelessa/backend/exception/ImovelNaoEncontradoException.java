package br.com.andrelessa.backend.exception;

public class ImovelNaoEncontradoException extends RuntimeException{

    public ImovelNaoEncontradoException(Long id){
        super("Imovel de id " + id + " Não Encontrada");
    }
    
}
