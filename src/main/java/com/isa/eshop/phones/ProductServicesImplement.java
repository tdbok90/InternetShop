package com.isa.eshop.phones;

import com.isa.eshop.repository.PhonesRepository;

import javax.ejb.Singleton;
import java.util.List;
import java.util.UUID;

@Singleton
public class ProductServicesImplement implements ProductServices {

    @Override
    public List<Phone> getPhoneList() {
        return PhonesRepository.getPhoneRepository();
    }


    @Override
    public Phone getPhoneByUUID(UUID uuid) {
        for (Phone phone:PhonesRepository.getPhoneRepository()) {
            if(phone.getId().equals(uuid)){
                return  phone;
            }
        }
        return null;
    }

    @Override
    public void addPhone(Phone phone) {
        PhonesRepository.getPhoneRepository().add(phone);
    }

    @Override
    public Phone getPhoneByModel(String model) {
        for (Phone phone:PhonesRepository.getPhoneRepository()) {
            if(phone.getModel().equals(model)){
                return  phone;
            }
        }
        return null;
    }

    @Override
    public void deletedPhone(UUID uuid) {
        for (Phone phone : PhonesRepository.getPhoneRepository()) {
            if (phone.getId().equals(uuid)) {
                PhonesRepository.getPhoneRepository().remove(phone);
            }
        }
    }

}
