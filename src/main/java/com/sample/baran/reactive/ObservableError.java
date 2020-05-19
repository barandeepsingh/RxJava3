package com.sample.baran.reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableError {
    public static void main(String[] args) {
        Observable.interval(1, 1, TimeUnit.SECONDS)
                .filter(e -> e % 2 == 0)
                .map(ObservableError::mapValues)

                .subscribe(System.out::println,
                        e->System.out.println("Error"+e.getMessage()),
                        ()->System.out.println("Done"));
        sleep(10000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static long mapValues(long number) {
        if(number==4) throw new RuntimeException("Something went wrong");
        return number;
    }

}
