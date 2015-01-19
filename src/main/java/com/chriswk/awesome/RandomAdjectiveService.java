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
        Observable<String> adjective = new RandomObservable(adjectives.size()).map(adjectives::get);
        return Observable.zip(Observable.interval(500, TimeUnit.MILLISECONDS), adjective.onBackpressureDrop(), (interval, word) -> word);
    }
}
