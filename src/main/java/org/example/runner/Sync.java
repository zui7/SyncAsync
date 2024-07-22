package org.example.runner;

import org.example.entity.Producer;
import org.example.entity.Products;
import org.example.impl.ProducerImpl;
import org.example.impl.ProductsImpl;

import java.util.Arrays;
import java.util.List;

public class Sync {

    private static final ProducerImpl producer = new ProducerImpl();
    private static final ProductsImpl product = new ProductsImpl();

    public static void main(String[] args) {
        final List<Producer> producerList = Arrays.asList(
                new Producer(1,"Apple"),
                new Producer(2,"Samsung"),
                new Producer(3,"OnePlus")
        );
        final List<Products> productList = Arrays.asList(
                new Products(11,"i"),
                new Products(21,"galaxy"),
                new Products(31,"plus")
        );

        Integer producerCount = producer.production(producerList);
        Integer productCount = product.production(productList);

        System.out.println("producer count " + producerCount + " product count" + productCount);
    }
}
