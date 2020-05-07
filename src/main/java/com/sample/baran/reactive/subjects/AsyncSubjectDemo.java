package com.sample.baran.reactive.subjects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.AsyncSubject;

public class AsyncSubjectDemo {
    //Only lastest emit for all
    public static void main(String[] args) throws InterruptedException {
        @NonNull AsyncSubject<Object> asyncSubject = AsyncSubject.create();
        asyncSubject.subscribe(e -> System.out.println("S1 " + e));

        asyncSubject.onNext("A");
        asyncSubject.onNext("B");
        asyncSubject.onNext("C");

        asyncSubject.subscribe(e -> System.out.println("S2 " + e));
        asyncSubject.onNext("D");
        asyncSubject.onNext("E");

        asyncSubject.onComplete();
    }
}
