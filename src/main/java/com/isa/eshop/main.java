package com.isa.eshop;


import com.isa.eshop.phones.Phone;
import com.isa.eshop.phones.ProductServicesImplement;

public class main {
    public static void main(String[] args) {
        ProductServicesImplement implement = new ProductServicesImplement();
        for(Phone phone: implement.getPhoneList()){
            System.out.println(phone);
        }
    }
}
