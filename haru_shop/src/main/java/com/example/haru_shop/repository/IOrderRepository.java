package com.example.haru_shop.repository;

import com.example.haru_shop.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Orders,Long> {
  @Query(value = "select * from orders join customer where orders.customer_id=customer.id and customer.id=:id",nativeQuery = true)


    List<Orders> findOrdersByCustomer( Long id);
}
