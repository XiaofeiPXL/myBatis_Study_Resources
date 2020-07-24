package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @program: day02_eesy_01mybatisCRUD
 * @description: 用户的持久层接口
 * @author: Xiaofei Wang
 * @created: 2020/07/19 17:01
 */


public interface IUserDao {
    /**
     * 查询所有用户
     *
     * @return 返回对应的用户信息列表
     */
    List<User> findAll();


    /**
     * 根据用户ID查询用户信息
     *
     * @param id 用户ID
     * @return 返回用户信息
     */
    User findUserById(Integer id);
}
