package com.sample.baran.reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalTime;

public class TheFlatMap {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("A", "B", "C", "D", "E").flatMap(e -> Observable.just(e).subscribeOn(Schedulers.computation())).map(str -> compute(str)).subscribe(System.out::println);

        Thread.sleep(7000);
    }

    private static String compute(String str) {
        return str + " printed by thread " + Thread.currentThread().getName()+ " at "+ LocalTime.now();
    }
}
