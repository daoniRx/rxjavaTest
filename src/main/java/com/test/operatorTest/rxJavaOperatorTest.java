package com.test.operatorTest;

import com.test.lottoTest.LottoNumber;
import com.test.lottoTest.LottoNumberObserver;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Operator Test
 */
public class rxJavaOperatorTest {
    public static void main(String[] args) {
        // just()
        Observable<Integer> obb = Observable.just(2,24,30,14);
        obb.subscribe(System.out::println);

        Observable.just("Hello world").subscribe(System.out::println);

    }
}
