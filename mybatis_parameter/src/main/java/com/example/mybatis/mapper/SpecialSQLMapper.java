package com.example.mybatis.mapper;

import com.example.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {
    /**
     * 模糊查詢
     * @param mohu
     * @return
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

    /**
     * 批次刪除
     * @param ids
     */
    void deleteBatchUser(@Param("ids") String ids);

    /**
     * 動態設置表名查詢用戶訊息
     * @param tableName
     * @return
     */
    List<User> getAllUser(@Param("tableName") String tableName);

    /**
     * 新增用戶信息
     * @param user
     */
    void insertUser(User user);
}
