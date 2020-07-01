package com.sample.baran.continuous.stream;

import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.ReplaySubject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RxJavaContinuousStreamService {
    public static void main(String[] args) {
        ReplaySubject<Integer> emitSource = ReplaySubject.create();
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            StreamSourceService.getStream().stream().forEach(emitSource::onNext);
            emitSource
                    .filter(item -> item % 2 == 0)
                    .map(item -> item * 2)
                    .map(item -> item + item)
                    .subscribeOn(Schedulers.from(executorService))
                    .doOnSubscribe(disposable -> {
                        System.out.println("Subscribed");
                    })
                    .doFinally(() -> {
                        System.out.println("Completed processing releasing resources "+Thread.currentThread().getName());
                    })
                    .doOnNext(item -> {
                        System.out.println("Processing item " + item+Thread.currentThread().getName());
                    })
                    .subscribe(item -> {
                        System.out.println("Printing value from emitter" + item+Thread.currentThread().getName());
                    });

        }, 2, 10, TimeUnit.SECONDS);
    }
}
