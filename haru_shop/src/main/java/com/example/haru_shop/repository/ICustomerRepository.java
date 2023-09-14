package com.example.haru_shop.repository;

import com.example.haru_shop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
//    @Query(value = "select * from customer where customer.id= :idCustomer",nativeQuery = true)
//    Customer findCustomerById(@Param("idCustomer") Long idCustomer);
@Query(value = "SELECT * from customer as c JOIN account a on a.id = c.account_id WHERE a.id= :customer",nativeQuery = true)
    Customer findUserByName(@Param("customer") Long customer);
}
