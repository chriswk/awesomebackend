package com.chriswk.awesome;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.reactivex.Observable;

public class IntervalDemo {
    private static final Logger SECOND = LogManager.getLogger("SECOND");
    private static final Logger HALFSECOND = LogManager.getLogger("HALF");

    public static void main(String... args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS).subscribe(SECOND::debug, SECOND::error, () -> SECOND.info("Complete"));
        Observable.interval(500, TimeUnit.MILLISECONDS).take(10).subscribe(HALFSECOND::debug, HALFSECOND::error,
                () -> HALFSECOND.info("Complete"));
        /**
         * Without this the method terminates
         **/
        Thread.sleep(20000);

    }
}
