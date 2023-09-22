package com.example.haru_shop.controller;

import com.example.haru_shop.config.JwtTokenUtil;
import com.example.haru_shop.model.Account;
import com.example.haru_shop.model.Customer;
import com.example.haru_shop.service.IAccountService;
import com.example.haru_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserDetailController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IAccountService iAccountService;
    @GetMapping("/userDetail")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<Customer>userDetail(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username =authentication.getName();
        Account account = iAccountService.findByUsername(username);
        Customer customer=iCustomerService.findUsersId(account.getId());
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
