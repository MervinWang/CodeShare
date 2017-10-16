package com.test.model;

import java.util.Optional;

/**
 * Created by wanghaiyang on 2017/10/12.
 */
public class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
