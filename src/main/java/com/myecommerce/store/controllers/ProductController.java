package com.myecommerce.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myecommerce.store.dtos.ProductRecordDto;
import com.myecommerce.store.models.ProductModel;
import com.myecommerce.store.repositories.ProductRepository;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;

/*
 * Maturidades de Richardson 
 * 1. Protocolo http
 * 2. Recursos com nome indicativo correto
 * 3. Metodos http de forma semântica
 * 
 */

// @RestController indica que essa classe é um controlador rest
@RestController
public class ProductController {

  @Autowired
  ProductRepository productRepository;


  @PostMapping("/products")
  public ResponseEntity<ProductModel> createProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
    var productModel = new ProductModel();
    BeanUtils.copyProperties(productRecordDto, productModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
  }



}
