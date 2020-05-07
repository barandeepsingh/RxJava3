package com.sample.baran.reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class ColdObservables {
    public static void main(String[] args) {
        List<String> namesList = new ArrayList<>();
        namesList.add("A");
        namesList.add("C");
        namesList.add("F");
        Observable<String> sourceIterable = Observable.fromIterable(namesList);

        sourceIterable.subscribe(System.out::print);

        System.out.println();

        namesList = returnUpdatedList(namesList);

        sourceIterable.subscribe(System.out::print);


    }

    private static List<String> returnUpdatedList(List<String> myList) {
        myList.add("Z");
        return myList;
    }
}
