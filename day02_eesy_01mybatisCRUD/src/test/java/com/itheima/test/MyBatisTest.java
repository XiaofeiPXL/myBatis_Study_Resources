package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: day02_eesy_01mybatisCRUD
 * @description: 测试MyBatis的CRUD操作
 * @author: Xiaofei Wang
 * @created: 2020/07/19 17:09
 */


public class MyBatisTest {
    SqlSession sqlSession;
    InputStream inputStream;
    IUserDao iUserDao;

    @Before
    public void init() throws IOException {
        //读取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession
        sqlSession = sqlSessionFactory.openSession();
        //获取dao的代理对象
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        List<User> userList = iUserDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存用户
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUserName("大橘");
        user.setUserAddress("53 Neptune Road");
        user.setUserSex("女");
        user.setUserBirthday(new Date());
        iUserDao.saveUser(user);
    }

    /**
     * 测试更新用户信息
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUserId(52);
        user.setUserName("智障");
        user.setUserBirthday(new Date());
        user.setUserSex("女");
        user.setUserAddress("219 Elizabeth Ave");
        iUserDao.updateUser(user);
    }

    /**
     * 测试删除用户信息
     */
    @Test
    public void testDeleteUser() {
        iUserDao.deleteUser(51);
    }

    /**
     * 测试根据用户ID查询用户信息
     */
    @Test
    public void testFindUserById() {
        User user = iUserDao.findUserById(53);
        System.out.println(user);
    }

    /**
     * 测试根据用户姓名模糊查询用户信息
     */
    @Test
    public void testFindUserByName() {
        List<User> users = iUserDao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询用户的总数
     */
    @Test
    public void testFindTotal() {
        int count = iUserDao.findTotal();
        System.out.println(count);
    }


    @Test
    public void testFindUserByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUserName("%王%");
        vo.setUser(user);
        List<User> users = iUserDao.findUserByVo(vo);
        for (User userItem : users) {
            System.out.println(userItem);
        }
    }

    /**
     * 根据条件查询,验证where和if标签
     */
    @Test
    public void testFindUserByCondition() {
        User user = new User();
        user.setUserName("老王");
        user.setUserSex("女");
        List<User> users = iUserDao.findUserByCondition(user);
        for (User userItem : users) {
            System.out.println(userItem);
        }
    }

    @Test
    public void testFindUserInIds(){
        QueryVo queryVo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(53);
        ids.add(54);
        ids.add(55);
        queryVo.setIds(ids);
        List<User> users = iUserDao.findUserInIds(queryVo);
        for(User userItems :users){
            System.out.println(userItems);
        }
    }
}
