package com.test.service;

/**
 * Created by wanghaiyang on 2017/7/10.
 */
public interface Defaultable {
    default String notRequired() {
        return "No required";
    }
}
