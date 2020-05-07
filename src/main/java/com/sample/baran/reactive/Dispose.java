package com.sample.baran.reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Dispose {
    private static final CompositeDisposable compositeDisposable = new CompositeDisposable();
    public static void main(String[] args) throws InterruptedException {

        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);
        @NonNull Disposable d1 = source.subscribe(e -> System.out.println("S1 -> " + e));
        //Thread.sleep(5000);
        //d1.dispose();
        @NonNull Disposable d2 = source.subscribe(e -> System.out.println("S2 -> " + e));
Thread.sleep(5000);
        compositeDisposable.addAll(d1,d2);
        compositeDisposable.dispose();
        Thread.sleep(10000);
        System.out.println("Completed processing");
    }

}
