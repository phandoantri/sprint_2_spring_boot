package com.example.haru_shop.repository;

import com.example.haru_shop.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType,Long> {
}
