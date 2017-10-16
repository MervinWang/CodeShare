package com.test.service;

import com.test.model.User;

/**
 * Created by wanghaiyang on 2017/7/6.
 */
@FunctionalInterface
public interface UserService {

    void test(User user);

    /**
     * 默认方法都必须提供一个默认实现，这样所有的接口实现者将会默认继承它（如果有必要的话，可以覆盖这个默认实现）
     */
    default void test1(){
        System.out.println("FunctionalInterface test");
    }
}
