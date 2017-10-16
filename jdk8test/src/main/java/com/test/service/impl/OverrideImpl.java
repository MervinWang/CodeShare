package com.test.service.impl;

import com.test.service.Defaultable;

/**
 * Created by wanghaiyang on 2017/7/10.
 */
public class OverrideImpl implements Defaultable {
    @Override
    public String notRequired() {
        return "override";
    }
}
