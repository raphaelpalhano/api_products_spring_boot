package com.myecommerce.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myecommerce.store.dtos.ProductRecordDto;
import com.myecommerce.store.dtos.ProductUpdateDto;
import com.myecommerce.store.models.ProductModel;
import com.myecommerce.store.repositories.ProductRepository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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


  @GetMapping("/products/{id}")
  public ResponseEntity<Object> getProduct(@PathVariable UUID id) {
    Optional<ProductModel> product = productRepository.findById(id);
    if (product.isEmpty()) { 
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");    
    }
    return ResponseEntity.status(HttpStatus.OK).body(product.get());

  }

    @GetMapping("/products")
  public ResponseEntity<List<ProductModel>> listProduct() {
    return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());

  }

  @PatchMapping("/products/{id}")
  public ResponseEntity<Object> updateProduct(@PathVariable UUID id, @RequestBody @Valid ProductUpdateDto productUpdateDto) {

    Optional<ProductModel> product = productRepository.findById(id);

    if(product.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");    
    }

    var productModel = product.get();

    BeanUtils.copyProperties(productUpdateDto, productModel);

    ProductModel updateProductModel = productRepository.saveAndFlush(productModel);


    return ResponseEntity.status(HttpStatus.OK).body(updateProductModel);

  }


  
  @PatchMapping("/products/{id}")
  public ResponseEntity<Object> deleteProduct(@PathVariable UUID id) {

    Optional<ProductModel> product = productRepository.findById(id);

    if(product.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");    
    }

    var productModel = product.get();

    productRepository.delete(productModel);


    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

  }

}
