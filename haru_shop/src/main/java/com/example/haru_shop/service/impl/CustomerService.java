package com.example.haru_shop.service.impl;

import com.example.haru_shop.model.Customer;
import com.example.haru_shop.repository.ICustomerRepository;
import com.example.haru_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

//    @Override
//    public Customer findCustomerById(Long id) {
//        return iCustomerRepository.findCustomerById(id);
//    }

    @Override
    public Customer findUsersId(Long customer) {
        return iCustomerRepository.findUserByName(customer);
    }
}
