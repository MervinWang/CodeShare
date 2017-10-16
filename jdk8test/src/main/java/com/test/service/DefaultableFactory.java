package com.test.service;

import java.util.function.Supplier;

/**
 * Created by wanghaiyang on 2017/7/10.
 */
public interface DefaultableFactory {
    static Defaultable create(Supplier<Defaultable> supplier) {
        return supplier.get();
    }
}
