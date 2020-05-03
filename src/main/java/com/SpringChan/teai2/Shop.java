package com.SpringChan.teai2;

import java.text.DecimalFormat;
import java.util.Random;

public interface Shop {
    DecimalFormat df = new DecimalFormat("#.##");
    void addProduct(String name, int price);
    void checkBasket();
    default double generatePrice(){
        Random random = new Random();
        return random.nextDouble()*250+50;
    }
}
