package com.cursoSpringMicroservices.demo.service;

import com.cursoSpringMicroservices.demo.dto.CarPostDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service //Usada para marcar classes que possuem funcionalidades de negócio da aplicação
public interface CarPostStoreService {

    List<CarPostDTO> obterCarrosAVenda(); //Busca todos os carros a venda do banco

    void mudarInfomacaoDeCarroAVenda(CarPostDTO carPostDTO, String id); //Metodo para alterar informações do carro a venda (PUT)

    void removerCarroAVenda(String id);
}
