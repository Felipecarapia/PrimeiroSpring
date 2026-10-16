package com.example.meu_primeiro_springboot.Missoes;


import com.example.meu_primeiro_springboot.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeMissao;
    private String dificuldade;

    //@OneToMany -> "One" (Uma) missão tem "Many" (varios) ninjas
    @OneToMany(mappedBy = "missoes")
    //mappedB - aqui é onde faz a ligação o nome é missoes ou seja a coluna onde vai ser colocado as missoes dos ninjas na class NinjaModel deve se chamar missoes
    private List <NinjaModel>  ninjas;  // é colocado uma list já que um missao tem vários ninjas

}


