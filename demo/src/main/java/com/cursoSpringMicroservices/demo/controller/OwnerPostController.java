package com.cursoSpringMicroservices.demo.controller;

import com.cursoSpringMicroservices.demo.dto.CarPostDTO;
import com.cursoSpringMicroservices.demo.dto.OwnerPostDTO;
import com.cursoSpringMicroservices.demo.service.OwnerPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class OwnerPostController { //Aqui que acontece a comunicação com o Front-End por meio dos EndPoints

    private final Logger LOG = (Logger) LoggerFactory.getLogger(OwnerPostController.class);

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping()
    public ResponseEntity criarProprietarioCarro(@RequestBody OwnerPostDTO ownerPostDTO){

        LOG.info("USANDO REST API - Criando Novo Usuário: {}", ownerPostDTO);

        ownerPostService.criarProprietarioCarro(ownerPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
