package com.test.service.impl;

import com.test.service.Defaultable;
import com.test.service.DefaultableFactory;

/**
 * Created by wanghaiyang on 2017/7/10.
 */
public class DefaultableImpl implements Defaultable {

    public static void main(String[] args) {
        //没有实现notRequired方法  默认使用接口实现逻辑
        Defaultable defaultable = DefaultableFactory.create(DefaultableImpl::new);
        System.out.println(defaultable.notRequired());

        //实现接口，则使用实现接口类逻辑
        defaultable = DefaultableFactory.create(OverrideImpl::new);
        System.out.println(defaultable.notRequired());
    }
}
