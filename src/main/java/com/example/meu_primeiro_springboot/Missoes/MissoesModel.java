package com.example.meu_primeiro_springboot.Missoes;


import com.example.meu_primeiro_springboot.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_cadastro_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeMissao;
    private String dificuldade;

    //@OneToMany -> "One" (Uma) missão tem "Many" (varios) ninjas
    @OneToMany(mappedBy = "missoes")
    private List <NinjaModel> ninjas;


    public MissoesModel(){

    }

    public MissoesModel(Long id, String nomeMissao, String dificuldade) {
        this.id = id;
        this.nomeMissao = nomeMissao;
        this.dificuldade = dificuldade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}


