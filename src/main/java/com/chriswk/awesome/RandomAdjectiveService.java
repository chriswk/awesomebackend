package com.chriswk.awesome;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class RandomAdjectiveService {
    private List<String> adjectives = List.of("cool", "ugly", "pretty", "inebriated", "belligerent", "mad",
            "complacent", "presumptuous", "prescient", "omniscient", "omnipotent", "bearded", "ponderous", "crazy",
            "glib");

    public Flowable<String> adjectives() {
        return RandomFlowable.randomInt(adjectives.size()).subscribeOn(Schedulers.computation()).map(adjectives::get)
                .onBackpressureDrop();
    }
}
