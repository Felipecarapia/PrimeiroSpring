package com.example.meu_primeiro_springboot;

import jakarta.persistence.*;

// Entity transforma uma classe em uma entidade do BD
// Nesse caso aqui transformei uma classe em uma entidade
@Entity
@Table(name = "tb_cadastro_de_ninjas")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Aqui gera o ID necessário e usamos IDENTITY pq faz números
    Long id;
    String nome;
    String email;
    int idade;

    public NinjaModel(){

    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
