package org.example.impl;

import org.example.entity.Products;

import java.util.List;

public class ProductsImpl {
    public Integer production(List<Products> products) {
        System.out.println("Starting products");
        products.forEach( p -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " created product " + p);
        });
        System.out.println("Finished products");
        return products.size();
    }
}
