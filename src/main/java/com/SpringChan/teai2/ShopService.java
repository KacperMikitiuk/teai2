package com.SpringChan.teai2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    private Shop shop;

    @Autowired
    public ShopService(Shop shop){
        this.shop = shop;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        shop.checkBasket();
    }
}
