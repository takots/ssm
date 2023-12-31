package com.example.mybatis.mapper;

import com.example.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    User getUserById(@Param("id") Integer id);
    List<User> getAllUser();

    Integer getCount();
    Map<String ,Object> getUserByIdToMap(@Param("id") Integer id);

//    Map<String ,Object> getAllUserToMap();
    List<Map<String ,Object>> getAllUserToMap();

    @MapKey("id")
    Map<String ,Object> getAllUserToMapKey();
}
