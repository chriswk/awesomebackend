package com.chriswk.awesome;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PassphrasePrinter {
    private static final Logger ADJECTIVE = LogManager.getLogger("ADJECTIVE");
    private static final Logger NOUN = LogManager.getLogger("NOUN");
    private static final Logger PASSPHRASE = LogManager.getLogger("PASSPHRASE");
    public static void main(String... args) {
    RandomObservable f = new RandomObservable(10);
        f.take(10).subscribe(System.out::println);

        final RandomAdjectiveService adjectiveService = new RandomAdjectiveService();
        adjectiveService.adjectives().take(10).subscribe(ADJECTIVE::debug);
        final RandomNounService nounService = new RandomNounService();
        PassphraseService service = new PassphraseService(new RandomAdjectiveService(), new RandomNounService());
        service.passphrase().take(10).subscribe(System.out::println);

    }
}
