package com.chriswk.awesome;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.reactivex.Flowable;

public class PassphrasePrinter {
    private static final Logger ADJECTIVE = LogManager.getLogger("ADJECTIVE");
    private static final Logger NOUN = LogManager.getLogger("NOUN");
    private static final Logger PASSPHRASE = LogManager.getLogger("PASSPHRASE");
    private static final Logger RANDOM = LogManager.getLogger("RANDOM");

    public static void main(String... args) throws InterruptedException {
        Flowable<Integer> f = RandomFlowable.randomInt(10);
        f.take(20).subscribe(RANDOM::debug, RANDOM::error, () -> RANDOM.debug("Completed"));

        final RandomAdjectiveService adjectiveService = new RandomAdjectiveService();
        adjectiveService.adjectives().subscribe(ADJECTIVE::debug, ADJECTIVE::error, () -> ADJECTIVE.debug("Completed"));
        final RandomNounService nounService = new RandomNounService();
        nounService.nouns().subscribe(NOUN::debug, NOUN::error, () -> NOUN.debug("Completed"));

        final Flowable<String> passphrase = new PassphraseService(new RandomAdjectiveService(), new RandomNounService())
                .passphrase(50);
        passphrase.subscribe(PASSPHRASE::debug, PASSPHRASE::error, () -> PASSPHRASE.debug("Completed"));
        Thread.sleep(5000);
    }
}
