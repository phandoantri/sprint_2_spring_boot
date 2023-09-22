package com.example.haru_shop.service.impl;

import com.example.haru_shop.model.OrderDetail;
import com.example.haru_shop.repository.IOrderDetailRepository;
import com.example.haru_shop.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;

    @Override
    public void saveOrderDetail(OrderDetail orderDetail) {
        iOrderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> getAllOrderDetail(Long id) {
        return iOrderDetailRepository.getAllOrderDetail(id);
    }
}
