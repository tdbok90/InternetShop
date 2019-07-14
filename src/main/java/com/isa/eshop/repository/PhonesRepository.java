package com.isa.eshop.repository;

import com.isa.eshop.phones.Phone;
import com.isa.eshop.phones.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PhonesRepository {
    private static List<Phone> phoneRepository = new ArrayList<>();

    public static List<Phone> getPhoneRepository() {
        if (phoneRepository.isEmpty()) {
            fillRepositoryWithDefaults();
        }
        return phoneRepository;
    }

    private static void fillRepositoryWithDefaults() {
        Phone phone4 = Phone.builder()
                .id(UUID.randomUUID())
                .model("Galaxy A40")
                .producer("Samsung")
                .price(BigDecimal.valueOf(729))
                .scrren(BigDecimal.valueOf(5.9))
                .createData(LocalDateTime.now())
                .status(ProductStatus.ACTIVE)
                .isPromoted(false)
                .build();
        phoneRepository.add(phone4);
        Phone phone5 = Phone.builder().
                id(UUID.randomUUID())
                .model("Redmi Note 7")
                .producer("Xiaomi")
                .price(BigDecimal.valueOf(489))
                .scrren(BigDecimal.valueOf(6.3))
                .createData(LocalDateTime.now())
                .status(ProductStatus.INACTIVE)
                .isPromoted(true).build();
        phoneRepository.add(phone5);
        Phone phone6 = Phone.builder()
                .id(UUID.randomUUID())
                .model("P30")
                .producer("Huawei")
                .price(BigDecimal.valueOf(2439))
                .scrren(BigDecimal.valueOf(6.1))
                .createData(LocalDateTime.now())
                .status(ProductStatus.INACTIVE)
                .isPromoted(true).build();
        phoneRepository.add(phone6);
        Phone phone1 = new Phone();
        phone1.setId(UUID.randomUUID());
        phone1.setModel("Q60");
        phone1.setProducer("Lg");
        phone1.setPrice(BigDecimal.valueOf(589));
        phone1.setScrren(BigDecimal.valueOf(6.26));
        phone1.setCreateData(LocalDateTime.now());
        phone1.setStatus(ProductStatus.ACTIVE);
        phone1.setPromoted(true);
        phoneRepository.add(phone1);
        Phone phone2 = new Phone();
        phone2.setId(UUID.randomUUID());
        phone2.setModel("Redmi 7");
        phone2.setProducer("Xiaomi");
        phone2.setPrice(BigDecimal.valueOf(299));
        phone2.setScrren(BigDecimal.valueOf(6.26));
        phone2.setCreateData(LocalDateTime.now());
        phone2.setStatus(ProductStatus.ACTIVE);
        phone2.setPromoted(false);
        phoneRepository.add(phone2);
        Phone phone3 = new Phone();
        phone3.setId(UUID.randomUUID());
        phone3.setModel("8 64 GB");
        phone3.setProducer("Iphon");
        phone3.setPrice(BigDecimal.valueOf(2799));
        phone3.setScrren(BigDecimal.valueOf(4.7));
        phone3.setCreateData(LocalDateTime.now());
        phone3.setStatus(ProductStatus.ACTIVE);
        phone3.setPromoted(true);
        phoneRepository.add(phone3);
    }


}
