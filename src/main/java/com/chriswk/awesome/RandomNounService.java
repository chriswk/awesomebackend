package com.chriswk.awesome;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

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
        Random r = new Random();
        int size = nouns.size();
        return Observable.create((observer) -> {
            while(!observer.isUnsubscribed()) {
                observer.onNext(nouns.get(r.nextInt(size)));
            }
            observer.onCompleted();
        });
    }
}
