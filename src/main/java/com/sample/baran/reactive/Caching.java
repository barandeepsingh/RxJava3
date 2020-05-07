package com.sample.baran.reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Caching {
    public static void main(String[] args) throws InterruptedException {
        @NonNull Observable<Long> longObservable = Observable.interval(1, TimeUnit.SECONDS).cache();

        longObservable.subscribe(e->System.out.println("Subscriber 1 : "+e));
        Thread.sleep(4000);

        longObservable.subscribe(e->System.out.println("Subscriber 2 : "+e));
        Thread.sleep(5000);

    }
}
