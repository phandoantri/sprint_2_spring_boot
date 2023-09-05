package com.example.haru_shop.service;

import com.example.haru_shop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> getAll(Pageable pageable);

    void deleteProduct(Long id);
}
