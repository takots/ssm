package com.example.spring.service;

public interface CheckoutService {
    /**
     * 買書
     * @param userId
     * @param bookIds
     */
    void checkout(Integer userId ,Integer[] bookIds);
}
