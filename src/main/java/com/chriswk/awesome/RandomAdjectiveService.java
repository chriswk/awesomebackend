package com.chriswk.awesome;

import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

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
        return new RandomObservable(adjectives.size()).subscribeOn(Schedulers.computation()).map(adjectives::get).onBackpressureDrop();
    }
}
