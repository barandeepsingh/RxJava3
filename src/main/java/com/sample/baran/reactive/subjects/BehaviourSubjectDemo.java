package com.sample.baran.reactive.subjects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class BehaviourSubjectDemo {
    //Only 1 last emit
    public static void main(String[] args) throws InterruptedException {
        @NonNull BehaviorSubject<Object> behaviorSubject = BehaviorSubject.create();
        behaviorSubject.subscribe(e -> System.out.println("S1 " + e));

        behaviorSubject.onNext("A");
        behaviorSubject.onNext("B");
        behaviorSubject.onNext("C");

        behaviorSubject.subscribe(e -> System.out.println("S2 " + e));
        behaviorSubject.onNext("D");
        behaviorSubject.onNext("E");

        behaviorSubject.onComplete();
    }
}
