package com.example.meu_primeiro_springboot.Ninjas;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {


    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas") // anotação que pegar infirmações
     public  String boasVindas (){
         return "Essa é minha primeira mensagem nessa rota";
     }

    // Adicionar ninja (CREAT) -----------POST
    @PostMapping("/adicionar")
    public NinjaModel criarNinja(NinjaModel ninja){
        return NinjaService.criarNi
    }

    // Mostrar todos os ninjas (READ) ----------- GET
    @GetMapping("/listar")
        public List<NinjaModel> listarNinjas() {
            return ninjaService.listarNinjas();
        }

    // Mostrar ninja com ID (READ) ------------ GET
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable long id) {
        return ninjaService.listaNinjaId(id);
    }
    //Alterar dado do ninja (UPDATE) ----------------- PUT
    @PutMapping("/alterar")
    public String alterar(){
        return "ninja alterado";
    }

    // Deletar Ninja (DELETE) ----------------- DELETE
    @DeleteMapping("/delete")
    public String delete(){
        return "ninja deletado";
    }
}

