package com.sample.baran.reactive.sampleapp;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        Observable<String> animals = Observable.just(
                "Tiger", "Elephant", "Cat", "Chameleon", "Frog", "Fish", "Turtle", "Flamingo");

        animals.groupBy(animal -> animal.charAt(0), String::toUpperCase)
                .concatMapSingle(Observable::toList)
                .subscribe(System.out::println);

    }

}
