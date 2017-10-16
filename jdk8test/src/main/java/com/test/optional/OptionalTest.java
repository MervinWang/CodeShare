package com.test.optional;

import com.test.model.Car;
import com.test.model.Insurance;
import com.test.model.Person;

import java.util.Optional;

/**
 * Created by wanghaiyang on 2017/8/24.
 */
public class OptionalTest {


    public static void main(String[] args) {

        //1.声明一个空的Optional
        Optional<Car> emptyCar = Optional.empty();
        //2.创建一个非空值创建
        Car car = new Car();
        Optional<Car> notEmptyCar = Optional.of(car);
        //3.创建一个可接受空值的Optional
        car = null;
        Optional<Car> enableNullCar = Optional.ofNullable(car);

        //从Optional中提取和转换值
        Insurance insurance = new Insurance();
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);
        System.out.println(name.isPresent());

        //使用flatMap链接Optional对象
        Person person = new Person();
        person.setCar(notEmptyCar);
        Optional<Person> optPerson = Optional.of(person);
        String name2 = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("unknow");
        System.out.println(name2);
    }
}
