package com.isa.eshop.phones;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Phone {
    private UUID id;
    private String model;
    private String producer;
    private BigDecimal price;
    private BigDecimal screen;
    private ProductStatus status;
    private LocalDateTime createDate;
    private boolean isPromoted;


}
