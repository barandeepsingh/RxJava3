package com.sample.baran.reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class OnFinallyDisposeSubscribeDemo {
    public static void main(String[] args) {
        //onFinallyDemo();
        //onDisposeDemo();
        onSubscribeDemo();
    }

    private static void onSubscribeDemo() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnSubscribe(disposable -> {
                    System.out.println("Subscribed");
                })
                .subscribe(System.out::println);
    }

    private static void onDisposeDemo() {
        //Sequence matters
        Observable.just(1, 2, 3, 4, 5)
                .doOnDispose(() -> System.out.println("In dispose"))
                .doOnSubscribe(disposable -> disposable.dispose())
                .subscribe(System.out::println);
    }

    private static void onFinallyDemo() {
        Observable.just(1,2,3,4,5)
                .doFinally(() -> System.out.println("In Finally"))
                .subscribe(System.out::println);

    }

}
