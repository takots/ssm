package com.example.mybatis.test;

import com.example.mybatis.mapper.SelectMapper;
import com.example.mybatis.pojo.User;
import com.example.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testGetUserByIdToMap(){
//        UPDATE ssm.t_user SET password = NULL, age = NULL WHERE id = 1;
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String ,Object> map = mapper.getUserByIdToMap(1);
        System.out.println(map);
        System.out.println(mapper.getUserByIdToMap(2));
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String ,Object>> list = mapper.getAllUserToMap();
        /**
         * [
         *   {gender=男, id=1, email=12345@qq.com, username=admin},
         *   {password=qwe123, gender=女, id=2, age=30, email=12345@qq.com, username=bob},
         *   {password=1qaz2wsx, gender=男, id=4, age=22, email=12345@qq.com, username=sherry}
         * ]
         */
        System.out.println(list);
    }

    @Test
    public void testGetAllUserToMapKey(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String ,Object> map = mapper.getAllUserToMapKey();
        /**
         * {
         *   1={gender=男, id=1, email=12345@qq.com, username=admin},
         *   2={password=qwe123, gender=女, id=2, age=30, email=12345@qq.com, username=bob},
         *   4={password=1qaz2wsx, gender=男, id=4, age=22, email=12345@qq.com, username=sherry}
         * }
         */
        System.out.println(map);
    }
}
