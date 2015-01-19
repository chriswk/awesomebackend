package com.chriswk.awesome;

import java.util.List;
import java.util.Random;
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
        final Observable<String> randomWord = new RandomObservable(nouns.size()).map((no) -> nouns.get(no));
        return Observable.zip(Observable.interval(500, TimeUnit.MILLISECONDS), randomWord.onBackpressureDrop(), (counter, word) -> word);
    }
}
