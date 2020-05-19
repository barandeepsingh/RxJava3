package com.sample.baran.reactive.remoteEmitter;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;

public class SubscriberService {

    public void subscribeToEmitter(ReplaySubject<Integer> emitSource) {
        emitSource
                .doOnSubscribe(disposable -> {
                    System.out.println("Subscribed");
                })
                .doFinally(() -> {
                    System.out.println("Completed processing releasing resources");
                })
                .doOnNext(item->{
                    System.out.println("Processing item "+item);
                })
                .subscribe(item -> {
                    System.out.println("Printing value from emitter"+item);
                });
    }
}
