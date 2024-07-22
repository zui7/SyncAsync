package org.example.runner;

import org.example.entity.Producer;
import org.example.entity.Products;
import org.example.impl.ProducerImpl;
import org.example.impl.ProductsImpl;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class AsyncCompletable {
    private static final ProducerImpl producer = new ProducerImpl();
    private static final ProductsImpl product = new ProductsImpl();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final List<Producer> producerList = Arrays.asList(new Producer(1, "Apple"), new Producer(2, "Samsung"), new Producer(3, "OnePlus"));
        final List<Products> productList = Arrays.asList(new Products(11, "i"), new Products(21, "galaxy"), new Products(31, "plus"));

        ExecutorService es = Executors.newFixedThreadPool(5);

        CompletableFuture<Integer> ct = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return producer.production(producerList);
            }
        }, es);

        CompletableFuture<Integer> cp = CompletableFuture.supplyAsync(() -> product.production(productList) , es);

//        CompletableFuture<Integer> cpp  = cp.thenApplyAsync(i -> {
//            System.out.println(Thread.currentThread().getName() + " convert..");
//            return i;
//        }, es);

        ct.thenAcceptAsync(integer -> {
            System.out.println(Thread.currentThread().getName() + " producer " + integer);
        });

        cp.thenAcceptAsync(integer -> System.out.println(Thread.currentThread().getName() + " product " + integer));

        System.out.println("end");
    }
}
