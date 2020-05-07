package com.sample.baran.reactive.subjects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class Subject {
    public static void main(String[] args) throws InterruptedException {
        @NonNull Observable<Integer> s1 = Observable.just(5, 10, 15, 20).observeOn(Schedulers.computation());
        @NonNull Observable<Integer> s2 = Observable.just(50, 100, 150, 200).observeOn(Schedulers.computation());

        @NonNull PublishSubject<Object> subject = PublishSubject.create();
        subject.subscribe(System.out::println);
        s1.subscribe(subject);
        s2.subscribe(subject);

        Thread.sleep(10000);

    }
}
