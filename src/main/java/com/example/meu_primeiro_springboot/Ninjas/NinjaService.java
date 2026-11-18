package com.example.meu_primeiro_springboot.Ninjas;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper){
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll(); //esse findAll é como se fose o SELECT fazendo query
    }

    // Listar ninjas por Id
    public NinjaModel listaNinjaId (long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        // Optional = caixinha que pode ter o ninja ou estar vazia (se o id não existir).
        // orElse(null) -> retorna o ninja se existir, senão retorna null.
        return ninjaPorId.orElse(null);
    }

    // Criar ninja
    public NinjaDTO criarNinja (NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.mapeandoNinjaModel(ninjaDTO); // NinjaModel recebe os valores de NinjaDTO
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.mapeandoNinjaDTO(ninja);

    }

    // Deletar ninja --> Tem que ser VOID porque não retorna nada apenas faz a query do banco
    public void  deltarNinjaPorId (long id){
        ninjaRepository.deleteById(id);
    }

    // Atualiar ninja


}
