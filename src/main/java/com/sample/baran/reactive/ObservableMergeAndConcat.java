package com.sample.baran.reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

import java.util.concurrent.TimeUnit;
//Concat maintains the order but merge does not
public class ObservableMergeAndConcat {
    public static void main(String[] args) throws InterruptedException {

        Observable<String> source1 = Observable.just("s1A","s1B","s1C");
        Observable<String> source2 = Observable.just("s2A","s2B","s2C");
        Observable merged = Observable.merge(source1,source2);

        merged.subscribe(System.out::println);

        System.out.println("===========================================");

        Function<Long, String> s3Function = num -> "s3: " + num;
        Function<Long, String> s4Function = num -> "s4: " + num;

        Observable<String> source3 = Observable.interval(1, TimeUnit.SECONDS).map(s3Function);
        Observable<String> source4 = Observable.interval(1,TimeUnit.SECONDS).map(s4Function);
        Observable merged34 = Observable.merge(source3,source4);
        Observable concatenated34 = source3.concatWith(source4);
        //merged34.subscribe(System.out::println);
        concatenated34.subscribe(System.out::println);
        Thread.sleep(20000);

    }
}
