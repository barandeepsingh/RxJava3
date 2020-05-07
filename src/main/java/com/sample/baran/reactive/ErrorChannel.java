package com.sample.baran.reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;

import java.io.IOException;


public class ErrorChannel {
    public static void main(String[] args) throws InterruptedException {
        //exDoOnError();
        //exOnErrorResumeNext();
        //exOnErrorReturn();
        //exOnErrorReturnItem();
        exRetryWithPredicate();
    }

    private static void exOnErrorResumeNext() {
        Function<Throwable, ObservableSource<Integer>> errorHandlingFunction = e -> {
            return Observable.just(2, 3, 4, 5, 6);
        };
        Observable.error(new Exception("This is an example error"))
                //           Observable.just(2,3,45,3)
                .onErrorResumeNext(errorHandlingFunction)
                .subscribe(e -> System.out.println("Result " + e), error -> System.out.println("Subscribed error " + error.getMessage()), () -> System.out.println("Completed"));
    }

    private static void exDoOnError() {
        Observable.error(new Exception("This is an example error"))
                //    Observable.just(2,3,45,3)
                .doOnError(error -> System.out.println("Error: " + error.getMessage()))
                .subscribe(e -> System.out.println("Result " + e), error -> System.out.println("Subscribed error " + error.getMessage()), () -> System.out.println("Completed"));
    }

    private static void exOnErrorReturn() {
        Observable.error(new IOException("This is an example error"))
                //    Observable.just(2,3,45,3)
                .onErrorReturn(error -> {
                    return error instanceof IOException ? "IO Exception" : "Some unknown exception";
                })
                .subscribe(e -> System.out.println("Result " + e), error -> System.out.println("Subscribed error " + error.getMessage()), () -> System.out.println("Completed"));
    }

    private static void exOnErrorReturnItem() {
        Observable.error(new IOException("This is an example error"))
        //Observable.just(2, 3, 45, 3)
                .onErrorReturnItem(Integer.valueOf(21))
                .subscribe(e -> System.out.println("Result " + e), error -> System.out.println("Subscribed error " + error.getMessage()), () -> System.out.println("Completed"));
    }
    private static void exRetryWithPredicate() {
        Observable.error(new IOException("This is an example error"))
        //Observable.just(2, 3, 45, 3)
                .retry(2,error->{
                    if(error instanceof IOException){
                        System.out.println("Retrying for "+error.getLocalizedMessage());
                        return true;
                    }else{
                        System.out.println("Not Retrying for "+error.getLocalizedMessage());
                        return false;
                    }
                })
                .subscribe(e -> System.out.println("Result " + e), error -> System.out.println("Subscribed error " + error.getMessage()), () -> System.out.println("Completed"));
    }

}
