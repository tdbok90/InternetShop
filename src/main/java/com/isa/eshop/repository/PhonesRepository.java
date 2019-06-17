package com.isa.eshop.repository;

import com.isa.eshop.phones.Phone;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PhonesRepository {
    private static List<Phone> phoneRepository = new ArrayList<>();

    public static List<Phone> getPhoneRepository(){
        if(phoneRepository.isEmpty()){
            fillRepositoryWithDefaults();
        }
        return phoneRepository;
    }

    private static void fillRepositoryWithDefaults(){
       Phone.builder()
               .id(UUID.randomUUID()).
               model("Galaxy A40").
               producer("Samsung").
               price(BigDecimal.valueOf(729)).
               scrren(BigDecimal.valueOf(5.9)).
               createData(LocalDateTime.now()).
               isPromoted(false);
       Phone.builder().
               id(UUID.randomUUID())
               .model("Redmi Note 7")
               .producer("Xiaomi")
               .price(BigDecimal.valueOf(489))
               .scrren(BigDecimal.valueOf(6.3))
               .createData(LocalDateTime.now())
               .isPromoted(true);
       Phone.builder()
               .id(UUID.randomUUID())
               .model("P30")
               .producer("Huawei")
               .price(BigDecimal.valueOf(2439))
               .scrren(BigDecimal.valueOf(6.1))
               .createData(LocalDateTime.now())
               .isPromoted(true);
    }




}
