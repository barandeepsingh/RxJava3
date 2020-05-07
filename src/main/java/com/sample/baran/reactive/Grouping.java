package com.sample.baran.reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;

import java.util.Comparator;

public class Grouping {
    public static void main(String[] args) {

        Observable<Employee> source = Observable.just(new Employee(1, "A", 4.5), new Employee(6, "B", 4.9), new Employee(7, "D", 4.9), new Employee(90, "F", 2.0), new Employee(108, "X", 2.0));

//Map   source.groupBy(e -> e.getRating()).flatMapSingle(e -> e.toMultimap(key -> e.getKey(), emp -> emp.getEmpName())).subscribe(System.out::println);
        source.groupBy(e -> e.getRating()).flatMapSingle(e -> e.toList()).subscribe(System.out::println);

    }
}
