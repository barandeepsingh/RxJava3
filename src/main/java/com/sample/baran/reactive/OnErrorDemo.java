package com.sample.baran.reactive;

import io.reactivex.rxjava3.core.Observable;

public class OnErrorDemo {
    public static void main(String[] args) {
        Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onError(new Exception("Unexpected issues"));
            emitter.onNext(2);
            emitter.onNext(3);

            emitter.onComplete();
        })
                .subscribe(item -> {
                    System.out.println(item);

                });
    }
}
