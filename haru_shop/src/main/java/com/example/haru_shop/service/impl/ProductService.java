package com.example.haru_shop.service.impl;

import com.example.haru_shop.model.Product;
import com.example.haru_shop.repository.IProductRepository;
import com.example.haru_shop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.getAllProduct(pageable);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public Product detailProduct(Long id) {
        return productRepository.detailProduct(id);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> searchProduct(Long id) {
        return productRepository.searchProduct(id);
    }

    @Override
    public List<Product> searchProductByNameProduct(String name) {
        return productRepository.searchProductByName(name);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }




}
