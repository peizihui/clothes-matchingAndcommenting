package cn.clothes.dao;


import cn.clothes.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nerd on 2016/6/30.
 */
@Repository
public interface UserDAO {
    int insertUser(User user);
    int deleteUser(String userName);
    int updateUser(User user);
    User queryUserByUserName(@Param("userName") String userName);
    List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);
    User queryByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

}
