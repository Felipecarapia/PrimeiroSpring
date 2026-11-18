package com.example.meu_primeiro_springboot.Ninjas;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper){
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaDTO> ninjasDTO = new ArrayList<>(); // aqui criar um lista vazia

        // Usa o Foreach para percorrer o ninjaModel que estar no banco
        for (NinjaModel ninja : ninjaRepository.findAll()) {
            ninjasDTO.add(ninjaMapper.mapeandoNinjaDTO(ninja));
            //Adiciona os valores que estão vindo da lista como os valores que estar vindo são do NinjaModel então
            //chamamos o Mapper e mapeamos o ninja para um DTO e salvamos
        }

        return ninjasDTO;
    }

    // Listar ninjas por Id
    public NinjaDTO listaNinjaId (Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        // Optional = caixinha que pode ter o ninja ou estar vazia (se o id não existir).
        // orElse(null) -> retorna o ninja se existir, senão retorna null.

        if (ninjaPorId.isPresent()){
            return ninjaMapper.mapeandoNinjaDTO(ninjaPorId.get());
        }
        return null;
    }

    // Criar ninja
    public NinjaDTO criarNinja (NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.mapeandoNinjaModel(ninjaDTO); // NinjaModel recebe os valores de NinjaDTO
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.mapeandoNinjaDTO(ninja);

    }

    // Deletar ninja --> Tem que ser VOID porque não retorna nada apenas faz a query do banco
    public void  deltarNinjaPorId (Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualiar ninja
    public NinjaDTO atualizarNinja (Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.mapeandoNinjaModel(ninjaDTO); //mapeia o model usando DTO
            ninjaAtualizado.setId(id); //
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado); // O ninja salvo é do tipo ninjaModel porém ele é salvo com a informações do ninjaModel mapeado com o DTO
            return ninjaMapper.mapeandoNinjaDTO(ninjaSalvo); // retorna o ninjaDTO recebendo as infomações do ninja salvo que é um model

        }
        return null;
    }

}
