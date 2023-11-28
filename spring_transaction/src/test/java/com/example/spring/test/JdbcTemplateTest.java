package com.example.spring.test;

import com.example.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


// 指定當前測試類在Spring 的測試環境中執行，此時就可以通過注入的方式直接獲取ioc容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
// 設置Spring 測試環境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        String sql = "insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql, "root", "123", 23, "F", "ads@gmag.com");
    }

    @Test
    public void testGetUserId() {
        String sql = "select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUserId(){
        String sql = "select * from t_user";
        List<User> list = jdbcTemplate.query(sql ,new BeanPropertyRowMapper<>(User.class));
        list.forEach(System.out::println);
    }

    @Test
    public void testGetCount(){
        String sql = "select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql ,Integer.class);
        System.out.println(count);
    }

}
