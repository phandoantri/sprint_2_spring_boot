package com.example.haru_shop.repository;

import com.example.haru_shop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select * from product where product.is_delete=false ",nativeQuery = true)
    Page<Product> getAllProduct(Pageable pageable);
@Transactional
@Modifying
@Query(value = "update product set product.is_delete=true where product.id= :id",nativeQuery = true)
    void deleteProduct(@Param("id") Long id);
}
