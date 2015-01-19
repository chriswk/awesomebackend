package com.chriswk.awesome;

import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import rx.Observable;
import rx.apache.http.ObservableHttp;

public class AsyncHttpObservable {
    public static Observable<String> getBody(String url, CloseableHttpAsyncClient client) {
        return ObservableHttp.createRequest(HttpAsyncMethods.createGet(url), client)
                .toObservable()
                .flatMap((response) -> response.getContent().map(String::new));
    }

    public static void main(String... args) {
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        client.start();
        getBody("http://www.wikipedia.com", client).subscribe(System.out::println, System.err::println, () -> System.out.println("Completed call"));
    }
}