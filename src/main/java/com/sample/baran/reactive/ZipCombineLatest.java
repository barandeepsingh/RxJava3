package com.sample.baran.reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ZipCombineLatest {
    public static void main(String[] args) throws InterruptedException {
        @NonNull Observable<Long> source1 = Observable.interval(2000, TimeUnit.MILLISECONDS).take(10);
        @NonNull Observable<Long> source2 = Observable.interval(3, TimeUnit.SECONDS).take(10);

//        Observable.zip(source1, source2, (e1, e2) -> "Source 1 :" + e1 + " ; Source 2: " + e2).subscribe(System.out::println);
        Observable.combineLatest(source1, source2, (e1, e2) -> "Source 1 :" + e1 + " ; Source 2: " + e2).subscribe(System.out::println);
        Thread.sleep(20000);
    }
}
