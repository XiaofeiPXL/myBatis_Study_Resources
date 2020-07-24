package com.itheima.dao;

import com.itheima.domain.QueryVo;
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
     * 保存用户
     *
     * @param user 没有返回
     */
    void saveUser(User user);

    /**
     * 更新用户信息
     *
     * @param user 用户对象
     */
    void updateUser(User user);

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     */
    void deleteUser(Integer id);

    /**
     * 根据用户ID查询用户信息
     * @param id 用户ID
     * @return 返回用户信息
     */
    User findUserById(Integer id);

    /**
     * 根据名称模糊查询用户信息
     * @param username 用户姓名
     * @return 用户列表
     */
    List<User> findUserByName(String username);

    /**
     * 查询总的用户数
     * @return 用户数量
     */
    int findTotal();

    /**
     * 根据QueryVo中的条件查询用户
     * @param vo 查询条件
     * @return 对应的用户信息列表
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件查询用户信息
     * @param user 查询的条件,有可能有用户名,有可能有性别,也有可能有地址,还有可能是都有
     * @return 用户信息列表
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryVo中提供的id集合,查询用户信息
     * @param vo QueryVo对象
     * @return 用户信息集合
     */
    List<User> findUserInIds(QueryVo vo);
}
