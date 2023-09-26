package com.myecommerce.store.dtos;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;

import jakarta.validation.constraints.DecimalMin;

public record ProductUpdateDto(String name, BigDecimal price, String description, @DecimalMin(value = "1") BigInteger quantity)  {

  
  
}
