package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @program: day03_eesy_04many2many
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/07/21 17:23
 */


public interface IRoleDao {
    /**
     * 查询所有角色
     * @return 角色列表
     */
    List<Role> findAll();
}
