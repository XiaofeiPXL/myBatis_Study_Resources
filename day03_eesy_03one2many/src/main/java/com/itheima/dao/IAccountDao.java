package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;

import java.util.List;

/**
 * @program: day03_eesy_03one2many
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/07/21 15:27
 */


public interface IAccountDao {
    /**
     * 查询所有账户,同时还要获取到当前账户的所属用户信息
     * @return 账户信息列表
     */
    List<Account> findAll();

    /**
     * 根据id查询用户
     * @return 用户信息
     */
    User findUserById(Integer id);

}
