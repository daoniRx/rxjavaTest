package com.test.hotColdTest;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

/**
 * HotObservable vs ColdObservable Test
 */
public class rxJavaHotColdTest {
    public static void main(String[] args) throws InterruptedException {
//        coldObservableText();
        hotObservableText();
    }

    public static void coldObservableText() {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        observable.subscribe(item -> System.out.println("Observer 1 : " + item));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        observable.subscribe(item -> System.out.println("Observer 2 : " + item));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void hotObservableText() throws InterruptedException {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        ConnectableObservable<Long> connectableObservable = observable.publish();

        connectableObservable.subscribe(item -> System.out.println("Observer 1 : " + item));
        connectableObservable.connect();
        Thread.sleep(3000);

        connectableObservable.subscribe(item -> System.out.println("Observer 2 : " + item));
        Thread.sleep(5000);
    }
}
