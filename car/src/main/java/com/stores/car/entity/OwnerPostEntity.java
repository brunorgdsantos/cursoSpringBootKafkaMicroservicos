package com.stores.car.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//Sinalizando para o Hibernate que esta não é uma classe comum, mas uma classe de entidade-relacionamento com o banco. É uma classe de representação de banco de dados
@Table(name="owner_post") //Vai criar uma tabela dessa classe com esse nome (car_post)
@Data //Criar os metodos gets e sets
@NoArgsConstructor //Serve para criar o contrutor padrão
public class OwnerPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Column(name = "tipo_proprietario")
    private String tipo;

    @Column(name = "contato_proprietario")
    private String numeroContato;
}
