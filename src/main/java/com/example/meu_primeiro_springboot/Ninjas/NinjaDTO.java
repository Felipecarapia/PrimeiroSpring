package com.example.meu_primeiro_springboot.Ninjas;

import com.example.meu_primeiro_springboot.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {


    private Long id;
    private String nome;
    private String imgUrl;
    private String email;
    private int idade;
    private String rank;
    private MissoesModel missoes;

}
