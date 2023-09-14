package com.example.haru_shop.service;

import com.example.haru_shop.model.Account;
import com.example.haru_shop.model.Cart;
import com.example.haru_shop.model.Customer;
import com.example.haru_shop.model.Product;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ICartService {
    Cart findByCustomersProduct(Customer customer, Product product);

    void addCart(Cart shoppingCart);

    List<Cart> getAllCart();

    void setQuantityShoppingCart(int quantity, Long id);

    void setQuantityShoppingCartPlus(int setQuantity, Long id);

    void deleteProductFromCart(Long id);

    void deleteCart(Cart cart);

    List<Cart> findAllCartByUserName(String username);
}
