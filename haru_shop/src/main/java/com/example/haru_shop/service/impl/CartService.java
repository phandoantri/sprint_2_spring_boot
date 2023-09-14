package com.example.haru_shop.service.impl;

import com.example.haru_shop.model.Account;
import com.example.haru_shop.model.Cart;
import com.example.haru_shop.model.Customer;
import com.example.haru_shop.model.Product;
import com.example.haru_shop.repository.ICartRepository;
import com.example.haru_shop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;
    @Override
    public Cart findByCustomersProduct(Customer customer, Product product) {
        return iCartRepository.findByCustomerAndProduct(customer,product);
    }

    @Override
    public void addCart(Cart shoppingCart) {
        iCartRepository.save(shoppingCart);
    }

    @Override
    public List<Cart> getAllCart() {
        return iCartRepository.findAll();
    }

    @Override
    public void setQuantityShoppingCart(int quantity, Long id) {
        Cart cart=iCartRepository.findById(id).get();
            cart.setQuantity(cart.getQuantity()-1);
            iCartRepository.save(cart);
    }

    @Override
    public void setQuantityShoppingCartPlus(int setQuantity, Long id) {
        Cart cart=iCartRepository.findById(id).get();
        cart.setQuantity(cart.getQuantity()+1);
        iCartRepository.save(cart);
    }

    @Override
    public void deleteProductFromCart(Long id) {
        iCartRepository.deleteById(id);
    }

    @Override
    public void deleteCart(Cart cart) {
        iCartRepository.delete(cart);
    }

    @Override
    public List<Cart> findAllCartByUserName(String username) {
        return iCartRepository.findCartByCustomer_Account_Username(username);
    }
}
