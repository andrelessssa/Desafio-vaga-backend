package br.com.andrelessa.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "anuncios")
@Data
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "imovel_id", unique = true)
    private Imovel imovel;

    @ManyToOne
    @JoinColumn(name = "corretor_id")
    private Corretor corretor;

    

    public Anuncio() {
    }



    public Anuncio(Imovel imovel, Corretor corretor) {
        this.imovel = imovel;
        this.corretor = corretor;
    }
    
}
