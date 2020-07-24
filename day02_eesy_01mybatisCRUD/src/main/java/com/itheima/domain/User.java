package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: day02_eesy_01mybatisCRUD
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/07/19 16:47
 */


public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String userAddress;
    private String userSex;
    private Date userBirthday;

    public User() {
    }

    public User(Integer userId, String userName, String userAddress, String userSex, Date userBirthday) {
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                '}';
    }
}
