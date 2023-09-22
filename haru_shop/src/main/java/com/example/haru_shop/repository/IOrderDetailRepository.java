package com.example.haru_shop.repository;

import com.example.haru_shop.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    @Query(value = "select * from order_detail join orders o on o.id = order_detail.orders_id where order_detail.orders_id=orders_id and o.id=:id",nativeQuery = true)
    List<OrderDetail> getAllOrderDetail(@Param("id") Long id);
}
