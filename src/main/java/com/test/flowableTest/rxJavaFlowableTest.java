package com.test.flowableTest;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Backpressure / Flowable Test
 */
public class rxJavaFlowableTest {
    public static void main(String[] args) throws InterruptedException {
//        backpressureTest();
        flowableTest();
    }

    private static void backpressureTest() throws InterruptedException {
        Observable.range(1, 10000)
                .doOnNext(integer -> System.out.println("Emit Data : "+integer))
                .observeOn(Schedulers.io())
                .subscribe(integer -> {
                    System.out.println("Consume Data : "+integer);
                    Thread.sleep(100);
                });
        Thread.sleep(100*10000);
    }

    private static void flowableTest() throws InterruptedException {
        Flowable.range(1, 10000)
                .doOnNext(integer -> System.out.println("Emit Data : "+integer))
                .observeOn(Schedulers.io())
                .subscribe(integer -> {
                    System.out.println("Consume Data : "+integer);
                    Thread.sleep(100);
                });
        Thread.sleep(100*10000);
    }
}
