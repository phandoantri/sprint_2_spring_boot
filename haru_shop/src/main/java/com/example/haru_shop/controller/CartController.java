package com.example.haru_shop.controller;

import com.example.haru_shop.config.JwtRequestFilter;
import com.example.haru_shop.config.JwtTokenUtil;
import com.example.haru_shop.model.*;
import com.example.haru_shop.repository.ICustomerRepository;
import com.example.haru_shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CartController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICartService iCartService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IAccountService iAccountService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<Cart> addProduct( @RequestParam(name = "quantity") int quantity,
                                           @RequestParam(name = "id") Long id) {
        Product product = iProductService.findProductById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username =authentication.getName();
        Account account = iAccountService.findByUsername(username);
        Customer customer=iCustomerService.findUsersId(account.getId());
        if (quantity > 0) {
            Cart shoppingCart = iCartService.findByCustomersProduct(customer, product);
            if (shoppingCart != null) {
                int amount = shoppingCart.getQuantity() + quantity;
                if (amount<=product.getQuantity()){
                    shoppingCart.setQuantity(amount);
                }else {
                    product.setQuantity(product.getQuantity());
                }

                iCartService.addCart(shoppingCart);
                return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
            }
        }
        Cart shoppingCartNew = new Cart(quantity, product, customer);
        iCartService.addCart(shoppingCartNew);
        return new ResponseEntity<>(shoppingCartNew, HttpStatus.CREATED);
    }
    @GetMapping("/listCart")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> getAllCart(){
        List<Cart> cartList=iCartService.getAllCart();
        return new ResponseEntity<>(cartList,HttpStatus.OK);
    }
    @PatchMapping("/minus/{setQuantity}/{id}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> setQuantityCart(@PathVariable int setQuantity, @PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username =authentication.getName();
        Account account = iAccountService.findByUsername(username);
        try {
            iCartService.setQuantityShoppingCart(setQuantity, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping("/plus/{setQuantity}/{id}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> setQuantityCartPlus(@PathVariable int setQuantity, @PathVariable Long id) {
//        try {
//            iCartService.setQuantityShoppingCartPlus(setQuantity, id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username =authentication.getName();
        Account account = iAccountService.findByUsername(username);
        try {
           return new ResponseEntity<>(iCartService.setQuantityShoppingCartPlus(setQuantity, id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteProductFromCart/{id}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> deleteProductFromCart(@PathVariable Long id){
        iCartService.deleteProductFromCart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

