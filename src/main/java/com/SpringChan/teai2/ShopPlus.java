package com.SpringChan.teai2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("Plus")
public class ShopPlus implements Shop {

    private List<Product> basket;

    @Value("${shop-info.tax}")
    private double tax;

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

    public double getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    @Override
    public void addProduct(String name, int price){
        Product product = new Product(name,price);
        basket.add(product);
    }

    @Override
    public void checkBasket() {
        System.out.println("Welocme to plus shop!");
        System.out.println("Basket contains:");
        double sum = 0;
        for (Product product : basket) {
            System.out.println(product.getName()+"/price "+df.format(product.getPrice())+" PLN");
            sum+=product.getPrice();
        }
        System.out.println("The price for all products is: "+df.format(sum)+" PLN");
        sum = sum*(1+tax/100);
        System.out.println("The price for all products with tax is: "+df.format(sum)+" PLN");
    }
}
