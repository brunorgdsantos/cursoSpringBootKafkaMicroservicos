package com.cursoSpringMicroservices.demo.service;

import com.cursoSpringMicroservices.demo.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service //Usada para marcar classes que possuem funcionalidades de negócio da aplicação
public interface OwnerPostService {
    void criarProprietarioCarro(OwnerPostDTO ownerPostDTO);
}
