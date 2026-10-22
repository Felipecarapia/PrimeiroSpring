
package com.example.meu_primeiro_springboot.Ninjas;


import com.example.meu_primeiro_springboot.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity transforma uma classe em uma entidade do BD
@Entity
@Table(name = "tb_cadastro_de_ninjas")
@Data // cria automaticamente os get e set
@NoArgsConstructor // cria automaticamente um construtor sem parametros
@AllArgsConstructor // cria automaticamente um costrutor com todos os parametro/atributos
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Aqui gera o ID necessário e usamos IDENTITY pq faz números
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "img_url")
    private String imgUrl;

    @Column(unique = true) // Estou dizendo que essa coluna é única ou seja não permite emails repetidos
    private String email;

    @Column (name = "idade")
    private int idade;
    //private List<MissoesModel> missoes;

    //@ManyToOne -> "Many"(muitos) ninjas tem "One"(uma) missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // FK - aqui é a criação da coluna missoe_id onde junta a missao com ninja ou seja toda vez que clicar nessa FK vamos pegar informações das duas tabelas
    private MissoesModel missoes;


}

