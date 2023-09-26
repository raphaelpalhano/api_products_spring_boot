package com.myecommerce.store.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myecommerce.store.dtos.ProductRecordDto;
import com.myecommerce.store.dtos.ProductUpdateDto;
import com.myecommerce.store.exceptions.HttpException;
import com.myecommerce.store.models.ProductModel;
import com.myecommerce.store.repositories.ProductRepository;


@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;


  public ResponseEntity<Object> getProduct(UUID id) {
    var productExist = validIfProductExist(id);
    return ResponseEntity.status(HttpStatus.OK).body(productExist.get());

  }


  public ResponseEntity<List<ProductModel>> listProducts() {
    return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
  }


  public ResponseEntity<ProductModel> createProduct(ProductRecordDto productRecordDto) {
    var productModel = new ProductModel();
    BeanUtils.copyProperties(productRecordDto, productModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
  }


  public ResponseEntity<Object> updateProduct(UUID id, ProductUpdateDto productUpdateDto) throws IllegalAccessException {
    var productExist = validIfProductExist(id);
    var productModel = productExist.get();
    
    if(!productUpdateDto.name().isEmpty()) {
      productModel.setName(productUpdateDto.name());
    }

    if(productUpdateDto.price() != null) {
      productModel.setPrice(productUpdateDto.price());
    }

    if(productUpdateDto.description() != null) {
      productModel.setDescription(productUpdateDto.description());
    }

    if(productUpdateDto.quantity() != null) {
      productModel.setQuantity(productUpdateDto.quantity());
    }



    ProductModel updateProductModel = productRepository.save(productModel);

    return ResponseEntity.status(HttpStatus.OK).body(updateProductModel);
  }


  public ResponseEntity<Object> deleteProduct(UUID id) {
    var productExist = validIfProductExist(id);

    var productModel = productExist.get();

    productRepository.delete(productModel);


    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

  }

  private Optional<ProductModel> validIfProductExist(UUID id) {
    Optional<ProductModel> product = productRepository.findById(id);
    if (product.isEmpty()) { 
        throw new HttpException("Produto nao encontrado", HttpStatus.NOT_FOUND.value()); 
    }

    return product;
  }


  

}
