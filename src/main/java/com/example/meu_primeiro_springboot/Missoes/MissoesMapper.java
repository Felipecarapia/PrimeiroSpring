package com.example.meu_primeiro_springboot.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel MapeandoMissoesModel (MissoesDTO missoesDTO){

        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNomeMissao(missoesDTO.getNomeMissao());
        missoesModel.setNinjas(missoesDTO.getNinjas());

        return missoesModel;
    }

    public MissoesDTO MapeandoMissoesDTO (MissoesModel missoesModel){

        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setNomeMissao(missoesModel.getNomeMissao());
        missoesDTO.setNinjas(missoesModel.getNinjas());

        return missoesDTO;
    }
}
