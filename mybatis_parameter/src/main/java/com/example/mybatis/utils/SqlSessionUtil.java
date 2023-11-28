package com.example.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        try {
            // 獲取核心配置文件的輸入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 獲取 sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 獲取 sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            // 獲取 sqlSession
            sqlSession = sqlSessionFactory.openSession(true);
        }catch (IOException e){
            e.printStackTrace();
        }
        return sqlSession;
    }
}
