package com.isa.eshop.phones;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @Column(name = "id_phone")
    private UUID id;
    @Column(name = "model_phone")
    private String model;
    @Column(name = "producer_phone")
    private String producer;
    @Column(name = "price_phone")
    private BigDecimal price;
    @Column(name = "scrren_phone")
    private BigDecimal scrren;
    @Column(name = "status_phone")
    private ProductStatus status;
    @Column(name = "createData_phone")
    private LocalDateTime createData;
    @Column(name = "isPromoted_phone")
    private boolean isPromoted;




}
