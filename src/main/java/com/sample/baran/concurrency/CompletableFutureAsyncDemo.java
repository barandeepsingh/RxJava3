package com.sample.baran.concurrency;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CompletableFutureAsyncDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(1, 100).forEach(i -> {
            CompletableFuture.supplyAsync(() -> getOrder(i), executorService)
                    .thenApply(order -> enrich(order))
                    .thenApply(order -> performPayment(order))
                    .thenApply(order -> dispatch(order))
                    .thenApply(order -> sendMail(order))
                    .thenAccept(order -> System.out.println(order.toString()))
                    .thenRun(() -> {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Completed processing of " + Thread.currentThread().getName());
                        System.out.println("------------------------------------------------------------");
                    });
        });
    }

    private static Order sendMail(Order order) {
        System.out.println("Sent mail for " + order.getOrderName());
        order.setMailSent(true);
        return order;
    }


    private static Order dispatch(Order order) {
        System.out.println("Dispatched for " + order.getOrderName());
        order.setDispatched(true);
        return order;
    }

    private static Order performPayment(Order order) {
        System.out.println("Paid for " + order.getOrderName());
        order.setPaid(true);
        return order;
    }

    private static Order enrich(Order order) {
        System.out.println("Enriched for " + order.getOrderName());
        order.setPrice(order.getPrice() * 2);
        return order;
    }

    private static Order getOrder(int orderId) {
        return new Order(orderId, "Order" + orderId, 100, false, false, false);
    }
}

@AllArgsConstructor
@Data
class Order {
    private int orderId;
    private String orderName;
    private int price;
    private boolean isPaid;
    private boolean isDispatched;
    private boolean isMailSent;
}

