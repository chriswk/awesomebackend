package com.chriswk.awesome;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class PassphraseService {
    RandomAdjectiveService adjectiveService;
    RandomNounService nounService;

    public PassphraseService(RandomAdjectiveService adjectiveService, RandomNounService nounService) {
        this.adjectiveService = adjectiveService;
        this.nounService = nounService;
    }

    public Flowable<String> passphrase(int msDelay) {
        return Flowable.zip(Flowable.interval(msDelay, TimeUnit.MILLISECONDS), adjectiveService.adjectives(),
                nounService.nouns(), (count, adjective, noun) -> adjective + " " + noun);
    }
}
