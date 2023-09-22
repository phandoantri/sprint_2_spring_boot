package com.example.haru_shop.service;

import com.example.haru_shop.model.Orders;

import java.util.List;

public interface IOrderService {
    void saveOrder(Orders orders1);

    List<Orders> getAllOrDerByIdCustomer(Long id);
}
