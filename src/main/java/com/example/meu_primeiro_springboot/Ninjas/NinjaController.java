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
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        // @RequestBody: pega o JSON enviado no corpo (body) da requisição
        // e converte automaticamente em um objeto NinjaModel.
        // Sem essa anotação, o objeto chega com os campos null.
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas (READ) ----------- GET
    @GetMapping("/listar")
        public List<NinjaModel> listarNinjas() {
            return ninjaService.listarNinjas();
        }

    // Mostrar ninja com ID (READ) ------------ GET
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable long id) {
        // @PathVariable: pega o valor que vem na própria URL, no lugar de {id},
        // e coloca na variável "id" do método.
        // Exemplo: GET /ninjas/listar/5  ->  id = 5
        return ninjaService.listaNinjaId(id);
    }
    //Alterar dado do ninja (UPDATE) ----------------- PUT
    @PutMapping("/alterar")
    public String alterar(){
        return "ninja alterado";
    }

    // Deletar Ninja (DELETE) ----------------- DELETE
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable long id){
        ninjaService.deltarNinjaPorId(id);
    }
}

