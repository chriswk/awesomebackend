package com.chriswk.awesome;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class PassphraseService {
    RandomAdjectiveService adjectiveService;
    RandomNounService nounService;

    public PassphraseService(RandomAdjectiveService adjectiveService, RandomNounService nounService) {
        this.adjectiveService = adjectiveService;
        this.nounService = nounService;
    }

    public Observable<String> passphrase(int msDelay) {
        return Observable.zip(Observable.interval(msDelay, TimeUnit.MILLISECONDS), adjectiveService.adjectives(), nounService.nouns(), (count, adjective, noun) -> adjective + " " +noun);
    }
}
