package com.chriswk.awesome;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class IntervalDemo {
    public static void main(String... args) {
        Observable.interval(1, TimeUnit.SECONDS).map((x) -> x).subscribe((e) -> System.out.println("1 second delay: step [" + e + "]")
                , System.err::println
                , () -> System.out.println("Complete"));
        Observable.interval(500, TimeUnit.MILLISECONDS).take(10).subscribe((e) -> System.out.println("500 ms delay: step [" + e + "]")
                , System.err::println
                , () -> System.out.println("Complete"));
    }
}
