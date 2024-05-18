package com.stores.car.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data //Gera os métodos Getters e Setters
@Builder //Gera um Construtor para a Classe com apenas os campos que você escolher
@NoArgsConstructor //Gera um Construtor sem argumentos (Parâmetros) para a Classe
@AllArgsConstructor //Gera um Construtor com todos os argumentos (Parâmetros) para a Classe
@JsonInclude
public class CarPostDTO {
    private String modelo;
    private String marca;
    private Double preco;
    private String descricao;
    private String versaoMotor;
    private String cidade;
    private String dataCriacao;
    private Long idProprietario;
    private String nomeProprietario;
    private String tipoProprietario;
    private String contato;

}
