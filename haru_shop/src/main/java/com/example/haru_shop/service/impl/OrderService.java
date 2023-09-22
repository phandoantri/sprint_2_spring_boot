package com.example.haru_shop.service.impl;

import com.example.haru_shop.model.Orders;
import com.example.haru_shop.repository.IOrderRepository;
import com.example.haru_shop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public void saveOrder(Orders orders1) {
        iOrderRepository.save(orders1);
    }

    @Override
    public List<Orders> getAllOrDerByIdCustomer(Long id) {
        return iOrderRepository.findOrdersByCustomer(id);
    }
}
