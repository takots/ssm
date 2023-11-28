package com.example.spring.dao;

public interface BookDao {
    /**
     * 查詢圖書的價格
     *
     * @return
     */
    Integer getPriceByBookId(Integer bookId);

    /**
     * 更新圖書的庫存
     *
     * @param bookId
     */
    void updateStock(Integer bookId);

    /**
     * 更新用戶的餘額
     *
     * @param userId
     * @param price
     */
    void updateBalance(Integer userId, Integer price);
}
