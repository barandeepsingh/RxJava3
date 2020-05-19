package com.sample.baran.reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class TakeSlipTakeWhileSkipWhileTakeLastSkipLastDemo {
    public static void main(String[] args) {
//        takeDemo();
//        takeDemoTime();
        //takeWhileDemo();
        //skipDemo();
        //         skipWhileDemo();
//        takeLastDemo();
        skipLastDemo();
    }

    private static void takeDemoTime() {
        Observable.just(1, 2, 3, 4, 5, 6).take(1, TimeUnit.MILLISECONDS).subscribe(System.out::println);
    }

    private static void skipLastDemo() {
        Observable.just(1, 2, 3, 4, 5, 6).take(2).subscribe(System.out::println);
    }

    private static void takeLastDemo() {
        Observable.just(1, 2, 3, 4, 5, 6).takeLast(2).subscribe(System.out::println);
    }

    private static void skipWhileDemo() {
        Observable.just(1, 2, 3, 4, 5, 6).skipWhile(item -> item < 2).subscribe(System.out::println);
    }

    private static void skipDemo() {
        Observable.just(1, 2, 3, 4, 5, 6).skip(2).subscribe(System.out::println);
    }

    private static void takeWhileDemo() {
        Observable.just(1, 2, 3, 4, 5, 6).takeWhile(item -> item < 4).subscribe(System.out::println);
    }

    private static void takeDemo() {
        Observable.just(1, 2, 3, 4, 5, 6).take(2).subscribe(System.out::println);
    }

}
