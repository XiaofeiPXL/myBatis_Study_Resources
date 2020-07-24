package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Account;
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
import java.util.List;

/**
 * @program: day02_eesy_01mybatisCRUD
 * @description: 测试MyBatis的CRUD操作
 * @author: Xiaofei Wang
 * @created: 2020/07/19 17:09
 */


public class MyBatisTest {
    SqlSession sqlSession;
    SqlSessionFactory sqlSessionFactory;
    InputStream inputStream;
    IAccountDao iAccountDao;
    IUserDao iUserDao;

    @Before
    public void init() throws IOException {
        //读取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession
        sqlSession = sqlSessionFactory.openSession();
        //获取dao的代理对象
        iAccountDao = sqlSession.getMapper(IAccountDao.class);
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 测试查询所有账户
     */
    @Test
    public void testFindAll() {
        List<Account> accounts = iAccountDao.findAll();
        for (Account ac : accounts) {
            System.out.println(ac);
        }
    }

    /**
     * 测试根据用户ID查询用户信息
     */
    @Test
    public void testFindUserById() {
        User user1 = iUserDao.findUserById(41);
        System.out.println(user1);

        sqlSession.close();
        sqlSession = sqlSessionFactory.openSession();

        //再次获取sqlSession对象,同时需要再次获得对应的dao接口代理对象
        iUserDao = sqlSession.getMapper(IUserDao.class);
        User user2 = iUserDao.findUserById(41);
        System.out.println(user2);
        //缓存:经常查询,不经常改变,数据的正确与否对最终结果影响不大
        //sqlSession的关闭以及update,delete,insert操作均会使一级缓存失效
        //sqlSession.clearCache()也会产生同样的影响
        System.out.println(user1 == user2);
    }
}
