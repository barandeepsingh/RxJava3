package com.sample.baran.reactive;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrencyHelloRxJava3 {
    public static void main(String[] args) {
        Observable<String> source = Observable.create(
                emmiter -> {
                    new Thread(() -> {
                        emmiter.onNext("Hello");
                        emmiter.onNext(" RxJava3");
                    }).start();
                }

        );
        source.subscribe(e -> System.out.println("Observer 1: " + e + " Thread: "+Thread.currentThread().getName()));
        source.subscribe(e -> System.out.println("Observer 2: " + e + " Thread: "+Thread.currentThread().getName()));

    }

}
