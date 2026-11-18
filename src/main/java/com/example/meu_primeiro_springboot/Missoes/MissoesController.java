package com.example.meu_primeiro_springboot.Missoes;

import com.example.meu_primeiro_springboot.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Listar missões
    @GetMapping("/listar")
    public List<MissoesModel> ListarMissoes (){
        return missoesService.ListarMissoes();
    }

    // Listar missões por id
    @GetMapping("/listar/{Id}")
    public MissoesModel ListarMissoesId (@PathVariable Long Id){
        return missoesService.ListarMissoesId(Id);
    }

    // Criar missões
    @PostMapping("/criar")
    public MissoesDTO CriarMissoes (@RequestBody MissoesDTO missoes){
        return missoesService.CriarMissoes(missoes);
    }

    @DeleteMapping("/deletar/{Id}")
    public void DeletarMissoesId ( @PathVariable Long Id){
        missoesService.deletarMissoesId(Id);
    }

}
