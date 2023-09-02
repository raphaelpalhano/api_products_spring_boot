package com.myecommerce.store.dtos;

import java.math.BigDecimal;
import java.math.BigInteger;

import jakarta.validation.constraints.DecimalMin;

public record ProductUpdateDto(String name, BigDecimal price, String description, @DecimalMin(value = "1") BigInteger quantity) {

  
}
