package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: day03_eesy_03one2many
 * @description: Test myBatis cache
 * @author: Xiaofei Wang
 * @created: 2020/07/22 15:33
 */


public class myBatisCacheTest {
    InputStream in;
    SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
    }

    @After
    public void destroy() throws IOException {
        in.close();
    }

    @Test
    public void testSecondLevelCache() {
        SqlSession session1 = factory.openSession();
        IUserDao iUserDao = session1.getMapper(IUserDao.class);
        User user1 = iUserDao.findUserById(41);
        System.out.println(user1);
        session1.close();

        SqlSession session2 = factory.openSession();
        IUserDao iUserDao1 = session2.getMapper(IUserDao.class);
        User user2 = iUserDao1.findUserById(41);
        System.out.println(user2);
        session2.close();

        System.out.println(user1 == user2);

        //mybatis二级缓存存的是数据而不是对象,因此两个对象不一致
    }
}
