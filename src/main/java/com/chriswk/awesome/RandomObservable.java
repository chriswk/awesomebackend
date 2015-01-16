package com.chriswk.awesome;

import java.util.Random;

import rx.Observable;

public class RandomObservable extends Observable<Integer> {

    public RandomObservable(int upperBound) {
        super(subscriber -> {
            Random random = new Random();
            while(!subscriber.isUnsubscribed()) {
                subscriber.onNext(random.nextInt(upperBound));
            }
            subscriber.onCompleted();
        });
    }
}
