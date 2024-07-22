package org.example.runner;

import org.example.entity.Producer;
import org.example.entity.Products;
import org.example.impl.ProducerImpl;
import org.example.impl.ProductsImpl;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class AsyncFuture {
    private static final ProducerImpl producer = new ProducerImpl();
    private static final ProductsImpl product = new ProductsImpl();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final List<Producer> producerList = Arrays.asList(new Producer(1, "Apple"), new Producer(2, "Samsung"), new Producer(3, "OnePlus"));
        final List<Products> productList = Arrays.asList(new Products(11, "i"), new Products(21, "galaxy"), new Products(31, "plus"));

        ExecutorService es = Executors.newFixedThreadPool(5);

        Future<Integer> future = es.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return producer.production(producerList);
            }
        });

        if(future.isDone()) {
            System.out.println(future.get());
        } else{
            System.out.println("not yet produced");
        }

        Future<Integer> futureP = es.submit(() -> product.production(productList));
        if(futureP.isDone()) {
            System.out.println(futureP.get());
        } else{
            System.out.println("no products yet");
        }

    }
}
