package com.example.haru_shop.repository;

import com.example.haru_shop.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Orders,Long> {
}
