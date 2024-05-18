package com.stores.car.service;

import com.stores.car.dto.CarPostDTO;
import com.stores.car.entity.CarPostEntity;
import com.stores.car.repository.CarPostRepository;
import com.stores.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service //Usada para marcar classes que possuem funcionalidades de negócio da aplicação
public class CarPostServiceImpl implements CarPostService{

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(carPostEntity);
    }

    @Override
    public List<CarPostDTO> obterCarrosAVenda() {
        List<CarPostDTO> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item->{
            listCarsSales.add(mapCarEntityToDTO(item));
        });
        return listCarsSales;
    }

    @Override
    public void mudarInfomacaoDeCarroAVenda(CarPostDTO carPostDTO, Long postId) {
        carPostRepository.findById(postId).ifPresentOrElse(item->{
            item.setDescricao(carPostDTO.getDescricao());
            item.setContato(carPostDTO.getContato());
            item.setPreco(carPostDTO.getPreco());
            item.setMarca(carPostDTO.getMarca());
            item.setVersaoMotor(carPostDTO.getVersaoMotor());
            item.setModelo(carPostDTO.getModelo());

            carPostRepository.save(item);

        }, ()-> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void removerCarroAVenda(Long postId) {
        carPostRepository.deleteById(postId);
    }

    private CarPostDTO mapCarEntityToDTO(CarPostEntity carPostEntity){
        return CarPostDTO.builder()
                .marca(carPostEntity.getMarca())
                .cidade(carPostEntity.getCidade())
                .modelo(carPostEntity.getModelo())
                .descricao(carPostEntity.getDescricao())
                .versaoMotor(carPostEntity.getVersaoMotor())
                .dataCriacao(carPostEntity.getDataCriacao())
                .nomeProprietario(carPostEntity.getOwnerPost().getNome())
                .preco(carPostEntity.getPreco()).build();
    }

    private CarPostEntity mapCarDtoToEntity(CarPostDTO carPostDTO){
        CarPostEntity carPostEntity = new CarPostEntity();

        ownerPostRepository.findById(carPostDTO.getIdProprietario()).ifPresentOrElse(item->{
            carPostEntity.setOwnerPost(item);
            carPostEntity.setContato(item.getNumeroContato());
        }, ()-> {
            throw new RuntimeException();
        });

        carPostEntity.setModelo(carPostDTO.getModelo());
        carPostEntity.setMarca(carPostDTO.getMarca());
        carPostEntity.setPreco(carPostDTO.getPreco());
        carPostEntity.setCidade(carPostDTO.getCidade());
        carPostEntity.setDescricao(carPostDTO.getDescricao());
        carPostEntity.setVersaoMotor(carPostDTO.getVersaoMotor());
        carPostEntity.setDataCriacao(String.valueOf(new Date()));

        return carPostEntity;
    }
}
