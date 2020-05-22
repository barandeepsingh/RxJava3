package com.sample.baran.concurrency;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

@AllArgsConstructor
@Data
public class ComplexComputation implements Callable<Message> {

    private int messageId;
    private String messageContent;
    private double computationalValue;

    @Override
    public Message call() {
        System.out.println("Starting computation for " + messageId + " in thread " + Thread.currentThread().getName());
        IntStream.range(1, 1000000).forEach(value -> Math.pow(computationalValue,Math.pow(computationalValue, computationalValue)));
        return Message.builder().messageId(messageId).messageContent(messageContent).build();
    }
}
