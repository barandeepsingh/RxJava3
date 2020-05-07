package com.sample.baran.reactive.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomThreadScheduler {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Observable<String> source = Observable.just("A", "B", "C", "D", "E").subscribeOn(Schedulers.from(executorService)).doFinally(executorService::shutdown);

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
