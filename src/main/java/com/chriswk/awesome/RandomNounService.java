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
        int size = nouns.size();
        Random r = new Random();
        return Observable.interval(500, TimeUnit.MILLISECONDS).map((counter) -> nouns.get(r.nextInt(size)));
    }
}
