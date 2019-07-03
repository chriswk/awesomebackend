package com.chriswk.awesome;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class RandomNounService {
    private final List<String> nouns = List.of("book", "elevator", "programmer", "president", "principal", "teacher",
            "intern", "footballer", "computer", "pearl", "ruby");

    public Flowable<String> nouns() {
        return RandomFlowable.randomInt(nouns.size()).subscribeOn(Schedulers.computation()).map(nouns::get)
                .onBackpressureDrop();
    }
}
