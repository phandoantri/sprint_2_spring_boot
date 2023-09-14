package com.example.haru_shop.repository;

import com.example.haru_shop.model.Account;
import com.example.haru_shop.model.Cart;
import com.example.haru_shop.model.Customer;
import com.example.haru_shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {

    Cart findByCustomerAndProduct(Customer customer, Product product);

    //    @Query(value = "SELECT * FROM shopping_cart as p\n" +
//            "INNER JOIN customers c on p.id_customers = c.id\n" +
//            "WHERE p.id_customers=:id\n"
//            , nativeQuery = true)
//    List<Cart> findAllCustomers(Long id);
    List<Cart> findCartByCustomer_Account_Username(String username);
}
