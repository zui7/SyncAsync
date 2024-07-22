package org.example.impl;

import org.example.entity.Producer;

import java.util.List;

public class ProducerImpl {

    public Integer production(List<Producer> producers) {
        System.out.println("Starting producers");
        producers.forEach( p -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " created producer " + p);
        });
        System.out.println("Finished production");
        return producers.size();
    }
}
