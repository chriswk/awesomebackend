package com.chriswk.awesome;

import rx.Observable;

public class PassphraseService {
    RandomAdjectiveService adjectiveService;
    RandomNounService nounService;

    public PassphraseService(RandomAdjectiveService adjectiveService, RandomNounService nounService) {
        this.adjectiveService = adjectiveService;
        this.nounService = nounService;
    }

    public Observable<String> passphrase() {
        return Observable.combineLatest(adjectiveService.adjectives(), nounService.nouns(), (adjective, noun) -> adjective + " " +noun);
    }
}
