package com.test.lottoTest;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class LottoNumberObserver implements Observer<LottoNumber> {

    @Override
    public void onSubscribe(@NonNull Disposable disposable) {

    }

    @Override
    public void onNext(@NonNull LottoNumber lottoNumber) {
        long order = lottoNumber.getOrder();
        long value = lottoNumber.getNumber();
        System.out.println(order + "번째 번호 : " + value);
    }

    @Override
    public void onError(@NonNull Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}
