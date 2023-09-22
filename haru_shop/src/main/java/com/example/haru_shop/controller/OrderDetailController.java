package com.example.haru_shop.controller;

import com.example.haru_shop.model.Account;
import com.example.haru_shop.model.Customer;
import com.example.haru_shop.model.OrderDetail;
import com.example.haru_shop.service.IAccountService;
import com.example.haru_shop.service.ICustomerService;
import com.example.haru_shop.service.IOrderDetailService;
import com.example.haru_shop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OrderDetailController {
    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IOrderDetailService iOrderDetailService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/orderDetail/{id}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> getAllOrderDetail(@PathVariable Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = iAccountService.findByUsername(username);
        Customer customer = iCustomerService.findUsersId(account.getId());
        List<OrderDetail> orderDetails=iOrderDetailService.getAllOrderDetail(id);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }
}
