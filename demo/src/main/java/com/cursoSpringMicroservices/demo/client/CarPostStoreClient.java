package com.cursoSpringMicroservices.demo.client;

import com.cursoSpringMicroservices.demo.dto.CarPostDTO;
import com.cursoSpringMicroservices.demo.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component //Essa Anotation é genérica. É usada para qualquer classe que precise ser gerenciada pelo Spring
public class CarPostStoreClient {
    private final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";
    private final String  POST_STORE_SERVICE_URI = "http://localhost:8080/sales";

    @Autowired //Permite injetar as dependências da classe RestTemplate dentro de restTemplate para toda a classe mãe (CarPostStoreClient)
    //injetar as dependências = Não vou precisar criar estruturas do tipo Carro carro = new Carro() para acessar seus métodos e depedências;
    RestTemplate restTemplate;

    public List<CarPostDTO> carrosAVendaClient(){ //Buscando todos os carros que estão a venda
        ResponseEntity<CarPostDTO[]> responseEntity = restTemplate.getForEntity(POST_STORE_SERVICE_URI + "/carros", CarPostDTO[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void proprietarioPostClient(OwnerPostDTO newUser){ //Inserindo novo proprietario
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDTO.class);
    }

    public void mudarInfomacaoDeCarrosAVendaClient(CarPostDTO carPostDTO, String id){
        restTemplate.put(POST_STORE_SERVICE_URI + "/carro/" + id, carPostDTO, CarPostDTO.class);
    }

    public void deletarCarroAVendaClient(String id){
        restTemplate.delete(POST_STORE_SERVICE_URI + "/carro/" + id);
    }
}
