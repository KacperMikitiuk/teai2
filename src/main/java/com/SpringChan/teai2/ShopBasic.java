package com.SpringChan.teai2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("Basic")
public class ShopBasic implements Shop {

    private List<Product> basket;

    public ShopBasic(){
        basket =new ArrayList<>();
        basket.add(new Product("carrot",generatePrice()));
        basket.add(new Product("tomato",generatePrice()));
        basket.add(new Product("potato",generatePrice()));
        basket.add(new Product("chicken",generatePrice()));
        basket.add(new Product("bread",generatePrice()));
    }

    @Override
    public void addProduct(String name, BigDecimal price){
        Product product = new Product(name,price);
        basket.add(product);
    }

    @Override
    public void checkBasket() {
        System.out.println("Welocme to basic shop!");
        System.out.println("Basket contains:");
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Product product : basket) {
            System.out.println(product.getName()+"/price "+product.getPrice()+" PLN");
            sum = sum.add(product.getPrice());
        }
        System.out.println("The price for all is: "+sum+" PLN");
    }
}
