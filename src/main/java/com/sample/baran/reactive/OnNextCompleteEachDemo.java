package com.sample.baran.reactive;

import io.reactivex.rxjava3.core.Observable;

public class OnNextCompleteEachDemo {
    public static void main(String[] args) {
        //onNextDemo();
        //onCompleteDemo();
        onEachDemo();
    }

    private static void onNextDemo() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnNext(item-> System.out.println("Next item is "+item))
                .subscribe(System.out::println);
    }

    private static void onCompleteDemo() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnComplete(()-> System.out.println("Completed the assigned task"))
                .subscribe(System.out::println);
    }
    private static void onEachDemo() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnEach(item-> System.out.println("Some task on item "+item.getValue()))
                .subscribe(System.out::println);
    }
}
