package com.test.model;

import java.util.Optional;

/**
 * Created by wanghaiyang on 2017/7/6.
 */
public class User {

   private String userName;

   private Long userId;

   private String nickName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

