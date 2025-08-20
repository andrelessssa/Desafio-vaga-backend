package br.com.andrelessa.backend.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrelessa.backend.Dto.ImovelDTO;
import br.com.andrelessa.backend.exception.ImovelNaoEncontradoException;
import br.com.andrelessa.backend.model.Imovel;
import br.com.andrelessa.backend.repository.ImovelRepository;



@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public Imovel criarImovel(ImovelDTO imovelDTO){
        Imovel imovel = new Imovel();
        BeanUtils.copyProperties(imovelDTO, imovel);
        return imovelRepository.save(imovel);
    }
    public List<Imovel> listarImoveis(){
        return imovelRepository.findAll();
    }
    public Imovel buscarImovelPorId(Long id){
        return imovelRepository.findById(id)
        .orElseThrow(() -> new ImovelNaoEncontradoException(id));
    }
    public Imovel atualizarImovel(Long id, ImovelDTO imovelDTO){
        Imovel imovelAtualizado = buscarImovelPorId(id);
        BeanUtils.copyProperties(imovelDTO, imovelAtualizado, "id");
        return imovelRepository.save(imovelAtualizado);
    }
    public void deletarImovel(Long id){
       Imovel imovel = buscarImovelPorId(id);
       imovelRepository.delete(imovel);
    }

    
}
