package com.isa.eshop.phones;

import javax.ejb.Local;
import java.util.List;
import java.util.UUID;


@Local
public interface ProductServices {

    List<Phone> getPhoneList();

    Phone getPhoneByUUID(UUID uuid);

    void addPhone(Phone phone);

    Phone getPhoneByModel(String model);

    void deletedPhone(UUID uuid);


}
