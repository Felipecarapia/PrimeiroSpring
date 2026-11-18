package com.example.meu_primeiro_springboot.Missoes;


import com.example.meu_primeiro_springboot.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<MissoesDTO> ListarMissoes(){
        List<MissoesDTO> missoesDTO = new ArrayList<>();

        for (MissoesModel missoes : missoesRepository.findAll()){
            missoesDTO.add(missoesMapper.MapeandoMissoesDTO(missoes));
        }
        return missoesDTO;
    }

    //Listar missoes por Id
    public MissoesDTO ListarMissoesId (Long Id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(Id);

        if (missoesPorId.isPresent()){
            return missoesMapper.MapeandoMissoesDTO(missoesPorId.get());
        }

        return null;
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

    // Atualizar missoes
    public MissoesDTO atualizarMissoes (Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id); // 1. buscar a missão no banco pelo id
        if (missaoExistente.isPresent()){ // 2. se existir:
            MissoesModel missaoAtualizada = missoesMapper.MapeandoMissoesModel(missoesDTO); //    3. converter DTO → Model
            missaoAtualizada.setId(id); //    4. colocar o id no Model
            MissoesModel missaoSalva    = missoesRepository.save(missaoAtualizada);//    5. salvar no banco
            return missoesMapper.MapeandoMissoesDTO(missaoSalva); //    6. converter Model → DTO e devolver
        }
        return null; // 7. se não existir, devolver null
    }
}
