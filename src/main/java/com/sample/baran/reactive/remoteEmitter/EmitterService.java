package com.sample.baran.reactive.remoteEmitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class EmitterService {
    private ReplaySubject<Integer> emitSource = ReplaySubject.create();

    public ReplaySubject<Integer> getEmitSource() {
        return emitSource;
    }

    public void readValuesFromDatabase() {
        List<Integer> fakeDbSimulator = Arrays.asList(new Integer[]{1, 2, 3, 4, 4, 5, 6, 7});
        fakeDbSimulator.stream().forEach(putValueInEmitSource);
        emitSource.onComplete();

    }

    Consumer<Integer> putValueInEmitSource= item-> {
        emitSource.onNext(item);
    };


}
