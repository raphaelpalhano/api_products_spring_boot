package com.myecommerce.store.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// implements serialize para indicar jvm a classe vai ser serializada
@Entity
@Table(name = "product")
public class ProductModel implements Serializable {
  private static final long serialVersionUID = 1L;
  

  // criando colunas

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private UUID id;
  private String name;
  private String description;
  private BigInteger quantity;
  private BigDecimal price;

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public BigInteger getQuantity() {
    return quantity;
  }
  public void setQuantity(BigInteger quantity) {
    this.quantity = quantity;
  }
  

  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public BigDecimal getPrice() {
    return price;
  }
  public void setPrice(BigDecimal price) {
    this.price = price;
  }
  
}
