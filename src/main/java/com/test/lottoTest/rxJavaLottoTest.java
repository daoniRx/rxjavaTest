package com.test.lottoTest;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Lotto Number Test
 */
public class rxJavaLottoTest {
    public static void main(String[] args) {
        Observable<LottoNumber> observable = getLottoNumbers();
        observable.blockingSubscribe(new LottoNumberObserver());
    }

    private void methoddd() {
//        Observable<Integer> obb = Observable.just(2,24,30,14);
//        obb.subscribe(System.out::println);
//        Observable.just("Hello world").subscribe(System.out::println);
    }

    private static Observable<LottoNumber> getLottoNumbers() {
        return Observable.create(
            emitter -> Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(n -> {
                    try {
                        emitter.onNext(LottoNumber.issue(n + 1)); // 0 부터 시작하기 때문에 +1
                    } catch (Exception e) {
                        emitter.onError(e);
                    }
                })
        );
    }
}
