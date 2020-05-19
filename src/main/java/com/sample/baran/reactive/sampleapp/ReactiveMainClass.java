package com.sample.baran.reactive.sampleapp;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.Map;

public class ReactiveMainClass {
    public static void main(String[] args) {
        TollObserver tollObserver = TollObserver.builder().build();
        Observable<Toll> tollObservable = tollObserver.emitSource();
        @NonNull Observable<List<Toll>> groupedObservableObservable = tollObserver.sortObservablesByDescendingNumberOfVehicles(tollObservable);
        tollObserver.subscribeToSource(groupedObservableObservable);
    }
}
