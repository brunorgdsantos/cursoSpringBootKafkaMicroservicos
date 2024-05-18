package com.stores.car.service;

import com.stores.car.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    void newPostDetails(CarPostDTO carPostDTO); //Vai salvar um novo post

    List<CarPostDTO> obterCarrosAVenda();

    void mudarInfomacaoDeCarroAVenda(CarPostDTO carPostDTO, Long postId);

    void removerCarroAVenda(Long postId);
}
