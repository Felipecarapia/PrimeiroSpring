package com.example.meu_primeiro_springboot.Missoes;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService (MissoesRepository missoesRepository, MissoesMapper missoesMapper){
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Listar todas as missoes
    public List<MissoesModel> ListarMissoes(){
        return missoesRepository.findAll();
    }

    //Listar missoes por Id
    public MissoesModel ListarMissoesId (Long Id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(Id);
        return missoesPorId.orElse(null);
    }

    //Criar missoes
    public MissoesDTO CriarMissoes (MissoesDTO missoesDTO){
        MissoesModel missao = missoesMapper.MapeandoMissoesModel(missoesDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.MapeandoMissoesDTO(missao);

    }

    // Deletar missoes
    public void deletarMissoesId (Long Id){
        missoesRepository.deleteById(Id);
    }
}
