package com.example.haru_shop.service;

import com.example.haru_shop.model.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    void saveOrderDetail(OrderDetail orderDetail);

    List<OrderDetail> getAllOrderDetail(Long id);
}
