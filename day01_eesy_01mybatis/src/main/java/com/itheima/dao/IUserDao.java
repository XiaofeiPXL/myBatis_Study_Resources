package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @program: day01_eesy_01mybatis
 * @description: 用户的持久层接口
 * @author: Xiaofei Wang
 * @created: 2020/07/16 23:12
 */

/**
 * 查询所有操作
 */
public interface IUserDao {
    List<User> findAll();
}
