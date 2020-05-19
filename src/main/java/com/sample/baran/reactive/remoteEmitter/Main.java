package com.sample.baran.reactive.remoteEmitter;

public class Main {
    public static void main(String[] args) {
        EmitterService emitterService = new EmitterService();
        emitterService.readValuesFromDatabase();
        SubscriberService subscriberService = new SubscriberService();
        subscriberService.subscribeToEmitter(emitterService.getEmitSource());
    }
}
