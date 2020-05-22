package com.sample.baran.concurrency;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentMain {
    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.now();
        List<Message> messageList = new ArrayList<>();
        List<Callable<Message>> callableList = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Message> message1 = new ComplexComputation(1, "Msg1", 1000000000000000d);
        Callable<Message> message2 = new ComplexComputation(2, "Msg2", 2000000000000000d);
        Callable<Message> message3 = new ComplexComputation(3, "Msg3", 3000000000000000d);

        callableList.add(message1);
        callableList.add(message2);
        callableList.add(message3);

//        futureMessageList.add(executorService.submit(message1));
//        futureMessageList.add(executorService.submit(message2));
//        futureMessageList.add(executorService.submit(message3));
//        Or else use invokeall

        try {
            List<Future<Message>> futureList = executorService.invokeAll(callableList);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }





        executorService.shutdown();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(String.format("Process completed in %1$s seconds", startTime.until(endTime, ChronoUnit.SECONDS)));

    }
}
