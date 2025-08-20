package br.com.andrelessa.backend.controller;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.andrelessa.backend.Dto.ImovelDTO;
import br.com.andrelessa.backend.model.Imovel;
import br.com.andrelessa.backend.service.ImovelService;



@RestController
@RequestMapping(value = "/imovel")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public ResponseEntity<Imovel> criarImovel(@RequestBody ImovelDTO imovelDTO ){
        Imovel imovelCriado = imovelService.criarImovel(imovelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(imovelCriado);
    }
    @GetMapping
    public ResponseEntity<List<Imovel>> listarImoveis(){
        return ResponseEntity.ok(imovelService.listarImoveis());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Imovel> buscarImovelPorId(@PathVariable Long id){
        return ResponseEntity.ok(imovelService.buscarImovelPorId(id));
    }
    @PatchMapping("/imovel/{id}")
    public ResponseEntity<Imovel> atualizarImovel(@PathVariable Long id, @RequestBody ImovelDTO imovelDTO){
        Imovel atualizado = imovelService.atualizarImovel(id, imovelDTO);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarImovel(@PathVariable Long id){
        imovelService.deletarImovel(id);
        return ResponseEntity.status(HttpStatus.OK).body("Imovel Deletado");

    }



    
}
