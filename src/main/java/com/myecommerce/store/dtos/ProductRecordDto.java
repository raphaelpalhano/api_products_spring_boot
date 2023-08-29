package com.myecommerce.store.dtos;

import java.math.BigDecimal;
import java.math.BigInteger;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Negative;

public record ProductRecordDto(@NotBlank String name, @Negative @NotNull BigDecimal price, String description, @DecimalMin(value = "1") @NotNull BigInteger quantity) {

  
}
