package com.test.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created by wanghaiyang on 2017/7/11.
 * 静态方法
 */
public class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    static Car create(Supplier<Car> supplier) {
        return supplier.get();
    }

    static void collide(Car car){
        System.out.println("'Collided:  " + car.toString());
    }

    public static void follow(Car another) {
        System.out.println("Following another:  " + another.toString());
    }

    void repeat(){
        System.out.println(this.toString());
    }

    public static void main(String[] args) {
        Car car = Car.create(Car :: new);
        List<Car> cars = Arrays.asList(car);
        cars.forEach(Car :: collide);
        cars.forEach(Car :: follow);
        car.repeat();
    }
}
