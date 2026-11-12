package com.example.meu_primeiro_springboot.Ninjas;



import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NinjaController {


    @GetMapping("/boasvindas") // anotação que pegar infirmações
     public  String boasVindas (){
         return "Essa é minha primeira mensagem nessa rota";
     }

    // Adicionar ninja (CREAT) -----------POST
    @PostMapping("/adicionar")
    public String adicionar(){
        return "ninja adicionado";
    }

    // Mostrar todos os ninjas (READ) ----------- GET
    @GetMapping("/Mostrar")
    public String mostrar(){
        return "ninja mostrado";
    }
    // Mostrar ninja com ID (READ) ------------ GET
    @GetMapping("/MostrarID")
    public String mostrarID(){
        return "ninja mostrado com ID";
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

