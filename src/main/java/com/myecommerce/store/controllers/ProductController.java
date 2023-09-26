package com.myecommerce.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myecommerce.store.dtos.ProductRecordDto;
import com.myecommerce.store.dtos.ProductUpdateDto;
import com.myecommerce.store.models.ProductModel;
import com.myecommerce.store.service.ProductService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;


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
  ProductService productService;
  

  @PostMapping("/products")
  public ResponseEntity<ProductModel> createProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
    return productService.createProduct(productRecordDto);
  }


  @GetMapping("/products/{id}")
  public ResponseEntity<Object> getProduct(@PathVariable UUID id) {
    return productService.getProduct(id);

  }

    @GetMapping("/products")
  public ResponseEntity<List<ProductModel>> listProduct() {
    return productService.listProducts();

  }

  @PatchMapping("/products/{id}")
  public ResponseEntity<Object> updateProduct(@PathVariable UUID id, @RequestBody @Valid ProductUpdateDto productUpdateDto) throws IllegalAccessException {
    return productService.updateProduct(id, productUpdateDto);

  }


  
  @DeleteMapping("/products/{id}")
  public ResponseEntity<Object> deleteProduct(@PathVariable UUID id) {
    return productService.deleteProduct(id);

  }

}
