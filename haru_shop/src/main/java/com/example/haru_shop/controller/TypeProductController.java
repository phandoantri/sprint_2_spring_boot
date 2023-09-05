package com.example.haru_shop.controller;

import com.example.haru_shop.model.ProductType;
import com.example.haru_shop.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TypeProductController {
    @Autowired
    private IProductTypeService iTypeProductService;
    @GetMapping("/type")
    public ResponseEntity<List<ProductType>> getAllType(){
        List<ProductType> productTypes=iTypeProductService.getAllProductType();
        if (productTypes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productTypes,HttpStatus.OK);
    }
}
