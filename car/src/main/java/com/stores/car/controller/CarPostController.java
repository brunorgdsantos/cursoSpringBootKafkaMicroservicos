package com.stores.car.controller;

import com.stores.car.dto.CarPostDTO;
import com.stores.car.service.CarPostService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDTO>> getCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.obterCarrosAVenda());
    }

    @PutMapping("/car/{id}")
    public ResponseEntity changeCarSales(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id){
        carPostService.mudarInfomacaoDeCarroAVenda(carPostDTO, Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity changeCarSale(@PathVariable("id") String id){
        carPostService.removerCarroAVenda(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
