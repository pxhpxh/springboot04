package com.example.springboot04.threads;

import java.util.concurrent.Callable;

/**
 * @ClassName CallableDemo
 * @Description TODO
 * @Author pxh
 * @Date 2023/5/8 20:16
 * @Version 1.0
 */

class CallableDemo implements Callable<Integer> {

    private int number;

    public CallableDemo(int number) {
        this.number = number;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int x = 1; x <= number; x++) {
            sum += x;
        }
        return sum;
    }
}

