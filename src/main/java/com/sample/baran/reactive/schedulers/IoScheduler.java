package com.sample.baran.reactive.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class IoScheduler {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> source = Observable.just("A", "B", "C", "D", "E").subscribeOn(Schedulers.io());

        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());
        source.subscribe(e->compute());



        Thread.sleep(5000);

    }

    private static void compute() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation done by thread : " + Thread.currentThread().getName());
    }

}
