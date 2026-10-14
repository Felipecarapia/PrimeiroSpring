package com.example.meu_primeiro_springboot.Ninjas;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NinjaController {


    @GetMapping("/boasvindas") // anotação que pegar infirmações
     public  String boasVindas (){
         return "Essa é minha primeira mensagem nessa rota";
     }
}
