package com.example.meu_primeiro_springboot.Ninjas;



import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + "ID: " + novoNinja.getId());
    }

    // Mostrar todos os ninjas (READ) ----------- GET
    @GetMapping("/listar")
        public List<NinjaDTO> listarNinjas() {
            return ninjaService.listarNinjas();
        }

    // Mostrar ninja com ID (READ) ------------ GET
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable Long id) {
        // @PathVariable: pega o valor que vem na própria URL, no lugar de {id},
        // e coloca na variável "id" do método.
        // Exemplo: GET /ninjas/listar/5  ->  id = 5
        return ninjaService.listaNinjaId(id);
    }
    //Alterar dado do ninja (UPDATE) ----------------- PUT
    @PutMapping("/atualizar")
    public NinjaDTO atualizarNinja (long id, NinjaDTO ninjaDTO){
        return ninjaService.atualizarNinja(id, ninjaDTO);
    }

    // Deletar Ninja (DELETE) ----------------- DELETE

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listaNinjaId(id) != null) {
            ninjaService.deltarNinjaPorId(id);
            return ResponseEntity.ok("Ninja deletado com sucesso. ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não foi encontrado");
        }
    }
}

