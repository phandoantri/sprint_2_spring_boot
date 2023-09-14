package com.example.haru_shop.controller;

import com.example.haru_shop.model.Product;
import com.example.haru_shop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/list")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')")
    public ResponseEntity<Page<Product>> listProduct(@PageableDefault Pageable pageable) {
        Page<Product> products = productService.getAll(pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')")
    public ResponseEntity<?> detailProduct(@PathVariable Long id) {
       Product product= productService.detailProduct(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<List<Product>> searchProduct(@PathVariable Long id){
        List<Product> products=productService.searchProduct(id);
        if (id==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    @GetMapping("/searchByName")
    public ResponseEntity<List<Product>> searchByNameProduct(@RequestParam String name){
        List<Product> productList=productService.searchProductByNameProduct(name);
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }
}
