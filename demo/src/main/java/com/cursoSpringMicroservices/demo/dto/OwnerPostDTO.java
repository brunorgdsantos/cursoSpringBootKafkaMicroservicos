package com.cursoSpringMicroservices.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Gera os métodos Getters e Setters
@Builder //Gera um Construtor para a Classe com apenas os campos que você escolher
@AllArgsConstructor //Gera um Construtor com todos os argumentos (Parâmetros) para a Classe
@NoArgsConstructor //Gera um Construtor sem argumentos (Parâmetros) para a Classe
@JsonInclude
public class OwnerPostDTO {
    private String nome;
    private String tipo;
    private String numeroContato;
}
