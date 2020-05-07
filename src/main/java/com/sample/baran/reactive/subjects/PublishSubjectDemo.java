package com.sample.baran.reactive.subjects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class PublishSubjectDemo {
    //Only after subscription starts
    public static void main(String[] args) throws InterruptedException {
        @NonNull PublishSubject<Object> publishSubject = PublishSubject.create();
        publishSubject.subscribe(e -> System.out.println("S1 " + e));

        publishSubject.onNext("A");
        publishSubject.onNext("B");
        publishSubject.onNext("C");

        publishSubject.subscribe(e -> System.out.println("S2 " + e));
        publishSubject.onNext("D");
        publishSubject.onNext("E");

        publishSubject.onComplete();
    }
}
