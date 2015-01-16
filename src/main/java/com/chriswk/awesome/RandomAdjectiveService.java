package com.chriswk.awesome;

import java.util.List;
import java.util.Random;

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
            "crazy");

    public Observable<String> adjectives() {
        return new RandomObservable(adjectives.size()).onBackpressureDrop().map(adjectives::get).onBackpressureDrop();
    }

}
