package br.com.andrelessa.backend.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrelessa.backend.Dto.CorretorDTO;
import br.com.andrelessa.backend.exception.CorretorNaoEncontradoException;
import br.com.andrelessa.backend.model.Corretor;
import br.com.andrelessa.backend.repository.CorretorRepository;



@Service
public class CorretorService {

    @Autowired
    private CorretorRepository corretorRepository;

     public Corretor criarCorretor(CorretorDTO corretorDTO){
        Corretor corretor = new Corretor();
        BeanUtils.copyProperties(corretorDTO, corretor);
        return corretorRepository.save(corretor);
    }
    public List<Corretor> listarCorretores(){
        return corretorRepository.findAll();
    }
    public Corretor buscarCorretorPorID(Long id){
        return corretorRepository.findById(id)
        .orElseThrow(() -> new CorretorNaoEncontradoException(id));
    }
    public Corretor atualizarCorretor(Long id, CorretorDTO corretorDTO){
        Corretor corretor = buscarCorretorPorID(id);
        BeanUtils.copyProperties(corretorDTO, corretor, "id");
        return corretorRepository.save(corretor);
    }
    public void deletarCorretor(Long id){
        Corretor corretor = buscarCorretorPorID(id);
        corretorRepository.delete(corretor);
    }


    
}
