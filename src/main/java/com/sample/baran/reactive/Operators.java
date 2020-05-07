package com.sample.baran.reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Predicate;


public class Operators {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.just(30,49,50,56,70,89);
        Predicate<Integer> isGtEq50 = value->value>=50;
        source.filter(isGtEq50).subscribe(System.out::println);
    }
}
