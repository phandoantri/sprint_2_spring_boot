package com.example.haru_shop.service.impl;

import com.example.haru_shop.model.ProductType;
import com.example.haru_shop.repository.IProductTypeRepository;
import com.example.haru_shop.service.IProductService;
import com.example.haru_shop.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository iProductTypeRepository;

    @Override
    public List<ProductType> getAllProductType() {
        return iProductTypeRepository.findAll();
    }
}
