package com.cursoSpringMicroservices.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Gera os métodos Getters e Setters
@Builder //Gera um Construtor para a Classe com apenas os campos que você escolher
@NoArgsConstructor //Gera um Construtor sem argumentos (Parâmetros) para a Classe
@AllArgsConstructor //Gera um Construtor com todos os argumentos (Parâmetros) para a Classe
@JsonInclude
public class CarPostDTO { //REPRESENTA AS POSTAGENS DE CARROS PARA VENDA
//DTO = Data Transfer Object = Objeto de transferência de dados
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
