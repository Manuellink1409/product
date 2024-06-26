package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {
    
    @Autowired
    private ProductRepository repository;

    @PostMapping
    public ResponseEntity<Long> postCreate(@RequestBody ProductDto producto) {
        Product prod = new Product(null,producto.getName(), producto.getDescription(), producto.getPrice());
        repository.save(prod);
        return ResponseEntity.ok().body(prod.getId());
    }

    
    

}
