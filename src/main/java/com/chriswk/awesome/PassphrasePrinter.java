package com.chriswk.awesome;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rx.Observable;

public class PassphrasePrinter {
    private static final Logger ADJECTIVE = LogManager.getLogger("ADJECTIVE");
    private static final Logger NOUN = LogManager.getLogger("NOUN");
    private static final Logger PASSPHRASE = LogManager.getLogger("PASSPHRASE");

    public static void main(String... args) throws InterruptedException {
        RandomObservable f = new RandomObservable(10);

        f.take(20).subscribe(System.out::println, System.err::println, () -> System.out.println("Completed"));

        final RandomAdjectiveService adjectiveService = new RandomAdjectiveService();
        adjectiveService.adjectives().take(20).subscribe(ADJECTIVE::debug, ADJECTIVE::error, () -> ADJECTIVE.debug("Completed"));
        final RandomNounService nounService = new RandomNounService();
        nounService.nouns().take(20).subscribe(NOUN::debug, NOUN::error, () -> NOUN.debug("Completed"));

        final Observable<String> passphrase = new PassphraseService(new RandomAdjectiveService(), new RandomNounService()).passphrase();
        passphrase.take(20).subscribe(PASSPHRASE::debug, PASSPHRASE::error, () -> PASSPHRASE.debug("Completed"));
        Thread.sleep(20000);
    }
}
