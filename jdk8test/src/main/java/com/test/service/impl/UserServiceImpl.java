package com.test.service.impl;

import com.test.model.User;
import com.test.service.UserService;

/**
 * Created by wanghaiyang on 2017/7/6.
 */
public class UserServiceImpl implements UserService{


    public void test(User user) {

    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.test1();
    }
}
