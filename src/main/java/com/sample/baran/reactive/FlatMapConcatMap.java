package com.sample.baran.reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class FlatMapConcatMap {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Welcome");
        myList.add("to");
        myList.add("RxJava3");
        Observable<String> source = Observable.fromIterable(myList);
        source.flatMap(e -> Observable.fromArray(e.split(""))).subscribe(System.out::println);

    }
}
