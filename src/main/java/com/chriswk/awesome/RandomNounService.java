package com.chriswk.awesome;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;

import static java.util.Arrays.asList;

public class RandomNounService {
    private final List<String> nouns = asList(
            "book",
            "elevator",
            "programmer",
            "president",
            "principal",
            "teacher",
            "intern",
            "footballer",
            "computer",
            "pearl",
            "ruby"
    );
    public Observable<String> nouns() {
        return new RandomObservable(nouns.size()).onBackpressureDrop().map(nouns::get).onBackpressureDrop();
    }
}
