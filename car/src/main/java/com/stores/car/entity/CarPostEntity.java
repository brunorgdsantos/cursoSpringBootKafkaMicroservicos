package com.stores.car.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Sinalizando para o Hibernate que esta não é uma classe comum, mas uma classe de entidade-relacionamento com o banco. É uma classe de representação de banco de dados
@Table(name="car_post") //Vai criar uma tabela dessa classe com esse nome (car_post)
@Data //Criar os metodos getters e setters
@NoArgsConstructor //Serve para criar o contrutor padrão
public class CarPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //Chave primaria

    @Column(name = "modelo_carro")
    private String modelo;

    @Column(name = "marca_carro")
    private String marca;

    @Column(name = "preco_carro")
    private Double preco;

    @Column(name = "descricao_carro")
    private String descricao;

    @Column(name = "versao_motor_carro")
    private String versaoMotor;

    @Column(name = "cidade_carro")
    private String cidade;

    @Column(name = "dataCriacao_carro")
    private String dataCriacao;

    @Column(name = "post_contat_carro")
    private String contato;

    @ManyToOne
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    private OwnerPostEntity ownerPost;

}
