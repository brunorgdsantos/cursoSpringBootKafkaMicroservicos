package com.cursoSpringMicroservices.demo.service;

import com.cursoSpringMicroservices.demo.client.CarPostStoreClient;
import com.cursoSpringMicroservices.demo.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Usada para marcar classes que possuem funcionalidades de negócio da aplicação
public class CarPostStoreServiceImpl implements CarPostStoreService{

    @Autowired //Permite injetar as dependências da classe CarPostStoreClient dentro de carPostStoreClient para toda a classe mãe (CarPostStoreServiceImpl)
    //injetar as dependências = Não vou precisar criar estruturas do tipo Carro carro = new Carro() para acessar seus métodos e depedências;
    private CarPostStoreClient carPostStoreClient;

    @Override
    public List<CarPostDTO> obterCarrosAVenda() {
        return carPostStoreClient.carrosAVendaClient();
    }

    @Override
    public void mudarInfomacaoDeCarroAVenda(CarPostDTO carPostDTO, String id) {
        carPostStoreClient.mudarInfomacaoDeCarrosAVendaClient(carPostDTO, id);
    }

    @Override
    public void removerCarroAVenda(String id) {
        carPostStoreClient.deletarCarroAVendaClient(id);
    }
}
