package com.chriswk.awesome;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;

import static java.util.Arrays.asList;

public class RandomAdjectiveService {
    private List<String> adjectives = asList(
            "cool",
            "ugly",
            "pretty",
            "inebriated",
            "belligerent",
            "mad",
            "complacent",
            "presumptuous",
            "prescient",
            "omniscient",
            "omnipotent",
            "bearded",
            "ponderous",
            "crazy",
            "glib");

    public Observable<String> adjectives() {
        Random r = new Random();
        final int size = adjectives.size();
        return Observable.create((observer) -> {
            while(!observer.isUnsubscribed()) {
                observer.onNext(adjectives.get(r.nextInt(size)));
            }
            observer.onCompleted();
        });
    }
}
