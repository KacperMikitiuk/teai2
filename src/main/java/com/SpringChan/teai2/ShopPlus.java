package com.SpringChan.teai2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("Plus")
public class ShopPlus implements Shop {

    private List<Product> basket;

    @Value("${shop-info.tax}")
    private BigDecimal tax;

    public ShopPlus(){
        basket =new ArrayList<>();
        basket.add(new Product("carrot",generatePrice()));
        basket.add(new Product("tomato",generatePrice()));
        basket.add(new Product("potato",generatePrice()));
        basket.add(new Product("chicken",generatePrice()));
        basket.add(new Product("bread",generatePrice()));
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    @Override
    public void addProduct(String name, BigDecimal price){
        Product product = new Product(name,price);
        basket.add(product);
    }

    @Override
    public void checkBasket() {
        System.out.println("Welocme to pro shop!");
        System.out.println("Basket contains:");
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Product product : basket) {
            System.out.println(product.getName()+"/price "+product.getPrice()+" PLN");
            sum= sum.add(product.getPrice());
        }
        System.out.println("The price for all products is: "+sum+" PLN");
        tax = tax.divide(BigDecimal.valueOf(100),2, RoundingMode.HALF_UP);
        tax = tax.add(BigDecimal.valueOf(1));
        sum = sum.multiply(tax);
        System.out.println("The price for all products with tax is: "+sum+" PLN");
    }
}
