package com.sample.baran.reactive.subjects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class PublishSubjectThreadSafeDemo {
    //Only after subscription starts
    public static void main(String[] args) throws InterruptedException {
        @NonNull PublishSubject<Object> publishSubject = PublishSubject.create();
        @NonNull Subject<Object> publishSubjectSerialized = publishSubject.toSerialized();
        publishSubjectSerialized.subscribe(e -> System.out.println("S1 " + e));

        publishSubjectSerialized.onNext("A");
        publishSubjectSerialized.onNext("B");
        publishSubjectSerialized.onNext("C");

        publishSubjectSerialized.subscribe(e -> System.out.println("S2 " + e));
        publishSubjectSerialized.onNext("D");
        publishSubjectSerialized.onNext("E");

        publishSubjectSerialized.onComplete();
    }
}
