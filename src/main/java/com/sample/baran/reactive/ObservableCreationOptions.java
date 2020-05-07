package com.sample.baran.reactive;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ObservableCreationOptions {
    public static void main(String[] args) {

        //create
        Observable<Integer> sourceCreate = Observable.create(emmiter->{
            emmiter.onNext(2);
            emmiter.onNext(3);
            emmiter.onNext(4);
        });
        sourceCreate.subscribe(System.out::println);

        //just
        Observable<Integer> sourceJust = Observable.just(3,5,7);
        sourceJust.subscribe(System.out::println);

        //iterable
        List<String> namesList = new ArrayList<>();
        namesList.add("A");
        namesList.add("C");
        namesList.add("F");
        Observable<String> sourceIterable = Observable.fromIterable(namesList);
        sourceIterable.subscribe(System.out::println);


        //Range
        Observable<Integer> sourceRange = Observable.range(3,10);
        sourceRange.subscribe(System.out::println);

        

    }



}
