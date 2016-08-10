package cn.clothes.dao;

import cn.clothes.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.annotation.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nerd on 2016/6/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDAOTest {

    @Resource
    private UserDAO userDAO;

    @Test
    public void insertUser() throws Exception {

        System.out.println("~~~");
    }

    @Test
    public void deleteUser() throws Exception {
        userDAO.deleteUser("userName");
    }

    @Test
    public void updateUser() throws Exception {

    }

    @Test
    public void queryUserByUserName() throws Exception {
        User user = userDAO.queryUserByUserName("userName");
        System.out.println("!!!!" + user);
    }

    @Test
    public void queryAll() throws Exception {
        System.out.println(userDAO.queryAll(0, 100));
    }

    @Test
    public void queryByUserNameAndPassword() throws Exception {
        User user = userDAO.queryByUserNameAndPassword("userName", "password");
        System.out.println("user" + user);
    }

}