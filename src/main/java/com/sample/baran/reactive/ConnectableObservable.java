package com.sample.baran.reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;
//Convert cold to hot observable
public class ConnectableObservable {
    public static void main(String[] args) throws InterruptedException {
        io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();
        source.connect();
        source.subscribe(System.out::println);
        Thread.sleep(10000);
        source.subscribe(System.out::println);
        Thread.sleep(10000);
    }
}
