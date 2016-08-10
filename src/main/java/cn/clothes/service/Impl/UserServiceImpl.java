package cn.clothes.service.Impl;

import cn.clothes.dao.UserDAO;
import cn.clothes.entity.User;
import cn.clothes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nerd on 2016/7/1.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }

    public int deleteUser(String userName) {
        return userDAO.deleteUser(userName);
    }

    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public User queryUserByUserName(String userName) {
        return userDAO.queryUserByUserName(userName);
    }

    public List<User> queryAll(int offset, int limit) {
        return userDAO.queryAll(0,1000);
    }

    public User queryByUserNameAndPassword(String userName, String password) {
        return userDAO.queryByUserNameAndPassword(userName, password);
    }
}
