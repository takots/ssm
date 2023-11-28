package com.example.mybatis.mapper;

import com.example.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User getUserByUserName(String username);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username ,String password);

    /**
     * 根据用户名查询用户信息(以map集合作為參數)
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String ,Object> map);

    void insertUser(User user);

    User checkLoginByParam(@Param("aaa") String username ,@Param("bbb") String password);
}
