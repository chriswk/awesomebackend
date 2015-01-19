package com.chriswk.awesome;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rx.Observable;

import static java.util.Arrays.asList;

public class PassphrasePrinter {
    private static final Logger ADJECTIVE = LogManager.getLogger("ADJECTIVE");
    private static final Logger NOUN = LogManager.getLogger("NOUN");
    private static final Logger PASSPHRASE = LogManager.getLogger("PASSPHRASE");

    public static void main(String... args) {
        RandomObservable f = new RandomObservable(10);

        f.take(20).subscribe(System.out::println);
        PassphraseService service = new PassphraseService(new RandomAdjectiveService(), new RandomNounService());
        /*service.passphrase().subscribe(System.out::println);
*/
/*
        final RandomAdjectiveService adjectiveService = new RandomAdjectiveService();
        adjectiveService.adjectives().take(20).subscribe(ADJECTIVE::debug);
        final RandomNounService nounService = new RandomNounService();
        nounService.nouns().take(20).subscribe(NOUN::debug);
*/

        final Observable<String> passphrase = new PassphraseService(new RandomAdjectiveService(), new RandomNounService()).passphrase();
        final Observable<String> from = Observable.from(asList("hello", "world"));
        final Observable<String> to = Observable.from(asList("world", "of hell"));
        final Observable<String> stringObservable = from.zipWith(to, (x, y) -> x + " " + y);
        stringObservable.subscribe(System.out::println);
        passphrase.take(10).subscribe(PASSPHRASE::debug);
    }
}
