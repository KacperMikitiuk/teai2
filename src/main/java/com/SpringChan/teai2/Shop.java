package com.SpringChan.teai2;

import java.math.BigDecimal;
import java.math.RoundingMode;


public interface Shop {
    void addProduct(String name, BigDecimal price);
    void checkBasket();
    default BigDecimal generatePrice(){
        BigDecimal bigDecimal = new BigDecimal(Math.random()*250+50);
        return bigDecimal.setScale(2, RoundingMode.HALF_UP);
    }
}
