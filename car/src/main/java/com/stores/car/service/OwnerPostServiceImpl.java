package com.stores.car.service;

import com.stores.car.dto.OwnerPostDTO;
import com.stores.car.entity.OwnerPostEntity;
import com.stores.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Usada para marcar classes que possuem funcionalidades de negócio da aplicação
public class OwnerPostServiceImpl implements OwnerPostService{

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {
        OwnerPostEntity ownerPost = new OwnerPostEntity();
        ownerPost.setNome(ownerPostDTO.getNome());
        ownerPost.setTipo(ownerPostDTO.getTipo());
        ownerPost.setNumeroContato(ownerPostDTO.getNumeroContato());

        ownerPostRepository.save(ownerPost);
    }
}
