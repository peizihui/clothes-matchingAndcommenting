package cn.clothes.service;

import java.util.List;

import cn.clothes.entity.User;

/**
 * Created by nerd on 2016/7/1.
 */
public interface UserService {
    int insertUser(User user);
    int deleteUser(String userName);
    int updateUser(User user);
    User queryUserByUserName(String userName);
    List<User> queryAll(int offset, int limit);
    User queryByUserNameAndPassword(String userName, String password);
}
