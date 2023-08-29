package com.myecommerce.store.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myecommerce.store.models.ProductModel;

// JPA é um ORM (Object Relational Mapping)
// ORM é um mapeamento entre objetos e tabelas do banco de dados
// O annotation @Repository é um esteriótipo para indicar que trata de uma interface do spring
@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

  
}
