package com.example.haru_shop.service.impl;

import com.example.haru_shop.model.Account;
import com.example.haru_shop.model.Cart;
import com.example.haru_shop.model.Customer;
import com.example.haru_shop.model.Product;
import com.example.haru_shop.repository.ICartRepository;
import com.example.haru_shop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @Override
//    public void setQuantityShoppingCartPlus(int setQuantity, Long id) {
//        Cart cart=iCartRepository.findById(id).get();
//        cart.setQuantity(cart.getQuantity()+1);
//        iCartRepository.save(cart);
//    }

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

    @Override
    public Cart findById(Long id) {
        return iCartRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<?> setQuantityShoppingCartPlus(int setQuantity, Long id) {
        Cart cart=iCartRepository.findById(id).get();
        if (setQuantity>0){
            if (cart.getQuantity()>=cart.getProduct().getQuantity()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Số lượng sản phẩm trong giỏ hàng vượt quá số lượng trong kho.!!");
            }
            else {
                cart.setQuantity(cart.getQuantity()+1);
                iCartRepository.save(cart);
                return new ResponseEntity<>(cart,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
