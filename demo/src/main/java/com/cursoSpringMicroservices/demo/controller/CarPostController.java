package com.cursoSpringMicroservices.demo.controller;

import com.cursoSpringMicroservices.demo.dto.CarPostDTO;
import com.cursoSpringMicroservices.demo.message.KafkaProducerMessage;
import com.cursoSpringMicroservices.demo.service.CarPostStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Classe que se comunica via Rest.
@RequestMapping("/api/car")
public class CarPostController { //Aqui que acontece a comunicação com o Front-End por meio dos EndPoints

    private final Logger LOG = (Logger) LoggerFactory.getLogger(CarPostController.class);

    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @PostMapping("/post")
    public ResponseEntity postCarrosAVenda(@RequestBody CarPostDTO carPostDTO){

        LOG.info("USANDO EVENTOS/MENSAGENS KAFKA - Producer Car Post Information: {}", carPostDTO);

        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> obterCarrosAVenda(){ //Retorna todos os carros
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.obterCarrosAVenda());
    }

    @PutMapping("/{id}")
    public ResponseEntity mudarInfomacaoDeCarrosAVenda(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id){
        carPostStoreService.mudarInfomacaoDeCarroAVenda(carPostDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCarroAVenda(@PathVariable("id") String id){
        carPostStoreService.removerCarroAVenda(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
