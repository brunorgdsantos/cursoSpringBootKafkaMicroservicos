package com.cursoSpringMicroservices.demo.service;

import com.cursoSpringMicroservices.demo.client.CarPostStoreClient;
import com.cursoSpringMicroservices.demo.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService{
    @Autowired//Permite injetar as dependências da classe CarPostStoreClient dentro de carPostStoreClient para toda a classe mãe (OwnerPostServiceImpl)
    //injetar as dependências = Não vou precisar criar estruturas do tipo Carro carro = new Carro() para acessar seus métodos e depedências;
    private CarPostStoreClient carPostStoreClient;

    @Override
    public void criarProprietarioCarro(OwnerPostDTO ownerPostDTO) {
        carPostStoreClient.proprietarioPostClient(ownerPostDTO);
    }
}
