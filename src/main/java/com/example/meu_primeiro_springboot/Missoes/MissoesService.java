package com.example.meu_primeiro_springboot.Missoes;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService (MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

    //Listar todas as missoes
    public List<MissoesModel> ListarMissoes(){
        return missoesRepository.findAll();
    }

    //Listar missoes por Id
    public MissoesModel ListarMissoesId (long Id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(Id);
        return missoesPorId.orElse(null);
    }

    //Criar missoes
    public MissoesModel CriarMissoes (MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    // Deletar missoes
    public void deletarMissoesId (long Id){
        missoesRepository.deleteById(Id);
    }
}
