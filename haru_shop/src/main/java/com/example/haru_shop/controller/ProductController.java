package com.example.haru_shop.controller;

import com.example.haru_shop.model.Product;
import com.example.haru_shop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public ResponseEntity<Page<Product>> listProduct(@PageableDefault Pageable pageable) {
        Page<Product> products = productService.getAll(pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
