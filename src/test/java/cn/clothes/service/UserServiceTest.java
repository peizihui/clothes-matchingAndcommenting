package cn.clothes.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by nerd on 2016/7/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void insertUser() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {

    }

    @Test
    public void updateUser() throws Exception {

    }

    @Test
    public void queryUserByUserName() throws Exception {

    }

    @Test
    public void queryAll() throws Exception {
        System.out.println(userService.queryAll(0, 100));
    }

    @Test
    public void queryByUserNameAndPassword() throws Exception {

    }

}