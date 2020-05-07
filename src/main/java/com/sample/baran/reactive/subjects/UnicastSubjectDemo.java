package com.sample.baran.reactive.subjects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.UnicastSubject;

public class UnicastSubjectDemo {
    //With cache mechanism
    public static void main(String[] args) throws InterruptedException {
        @NonNull UnicastSubject<Object> unicastSubject = UnicastSubject.create();
        unicastSubject.subscribe(e -> System.out.println("S1 " + e));

        unicastSubject.onNext("A");
        unicastSubject.onNext("B");
        unicastSubject.onNext("C");

        unicastSubject.onComplete();
    }
}
