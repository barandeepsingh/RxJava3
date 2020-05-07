package com.sample.baran.reactive.subjects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.ReplaySubject;

public class ReplaySubjectDemo {
    //With cache mechanism
    public static void main(String[] args) throws InterruptedException {
        @NonNull ReplaySubject<Object> replaySubject = ReplaySubject.create();
        replaySubject.subscribe(e -> System.out.println("S1 " + e));

        replaySubject.onNext("A");
        replaySubject.onNext("B");
        replaySubject.onNext("C");

        replaySubject.subscribe(e -> System.out.println("S2 " + e));
        replaySubject.onNext("D");
        replaySubject.onNext("E");

        replaySubject.onComplete();
    }
}
