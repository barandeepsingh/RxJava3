package com.sample.baran.reactive.subjects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public class UnicastSubjectBufferDemo {
    //With cache mechanism
    public static void main(String[] args) throws InterruptedException {
        @NonNull UnicastSubject<Object> subject = UnicastSubject.create();

        Observable.interval(500, TimeUnit.MILLISECONDS).subscribe(subject);
        Thread.sleep(2000);

        subject.subscribe(e -> System.out.println("S1 " + e));
        Thread.sleep(2000);
    }
}
