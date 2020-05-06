package com.sample.baran.reactive;
import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava3 {
    public static void main(String[] args) {
        Observable<String> source = Observable.create(
                e -> {
                    e.onNext("Hello");
                    e.onNext(" RxJava3");
                }

        );
        source.subscribe(e -> System.out.println("Observer 1: "+e));
        source.subscribe(e -> System.out.println("Observer 2: "+e));
    }

}
