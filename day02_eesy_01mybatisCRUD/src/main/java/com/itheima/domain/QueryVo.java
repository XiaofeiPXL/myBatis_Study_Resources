package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @program: day02_eesy_01mybatisCRUD
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/07/19 20:57
 */


public class QueryVo implements Serializable {
    private User user;

    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
