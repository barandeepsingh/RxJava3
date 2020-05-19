package com.sample.baran.reactive.sampleapp;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observables.GroupedObservable;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public class TollObserver {
    public Observable<Toll> emitSource() {
        return Observable.create(emitter -> {
            emitter.onNext(new Toll(LocalDateTime.now(), "UP32 DA 8514", "UP"));
            emitter.onNext(new Toll(LocalDateTime.now(), "DL2F ED 8614", "DL"));
            emitter.onNext(new Toll(LocalDateTime.now(), "UP16 DS 3514", "UP"));
            emitter.onNext(new Toll(LocalDateTime.now(), "MH14 KL 8514", "MH"));
            emitter.onNext(new Toll(LocalDateTime.now(), "KA16 ED 5414", "KA"));

            emitter.onComplete();

        });
    }

    public @NonNull Observable<List<Toll>> sortObservablesByDescendingNumberOfVehicles(Observable<Toll> emitSource) {
        return emitSource.groupBy(Toll::getState).flatMapSingle(entry->entry.toList());
    }

    public void subscribeToSource(Observable<List<Toll>> modifiedEmitSource) {


        Consumer<List<Toll>> dataChannelConsumer = stringTollGroupedObservable -> {
            System.out.println(stringTollGroupedObservable);
        };

        modifiedEmitSource.subscribe(dataChannelConsumer);
    }

}
