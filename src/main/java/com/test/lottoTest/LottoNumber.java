package com.test.lottoTest;

import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@ToString
public class LottoNumber {
    public static final Random random = new Random();

    private long number;
    private long order;

    public LottoNumber(long number, long order) {
        this.number = number;
        this.order = order;
    }

    public static LottoNumber issue(long order) {
        if (order > 6) throw new RuntimeException("6번째 까지만 발급이 가능합니다.");
        int randomNumber = random.nextInt(45);
        return new LottoNumber(randomNumber, order);
    }
}
