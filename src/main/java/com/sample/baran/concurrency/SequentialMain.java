package com.sample.baran.concurrency;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SequentialMain {
    public static void main(String[] args) {

        LocalDateTime startTime = LocalDateTime.now();

        ComplexComputation complexComputation1 = new ComplexComputation(1, "Msg1", 100000);
        ComplexComputation complexComputation2 = new ComplexComputation(2, "Msg2", 200000);
        ComplexComputation complexComputation3 = new ComplexComputation(3, "Msg3", 300000);

        Message call1 = complexComputation1.call();
        Message call2 = complexComputation2.call();
        Message call3 = complexComputation3.call();

        System.out.println(call1.getMessageContent()+Thread.currentThread().getName());

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(String.format("Process completed in %1$s seconds", startTime.until(endTime, ChronoUnit.SECONDS)));

    }

}
