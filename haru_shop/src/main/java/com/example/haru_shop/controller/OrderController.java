package com.example.haru_shop.controller;

import com.example.haru_shop.config.JwtRequestFilter;
import com.example.haru_shop.model.*;
import com.example.haru_shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICartService iCartService;
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IOrderDetailService iOrderDetailService;

    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping("/payment/{totals}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public void payment(@PathVariable int totals) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = iAccountService.findByUsername(username);
        Customer customer = iCustomerService.findUsersId(account.getId());

        Orders orders = new Orders();
        orders.setCustomer(customer);
        orders.setTotalPayment(totals);
        orders.setCreateDate(LocalDateTime.now());
        iOrderService.saveOrder(orders);


        List<Cart> cartList = iCartService.findAllCartByUserName(username);
        for (int i = 0; i < cartList.size(); i++) {
            Product product = iProductService.findProductById(cartList.get(i).getProduct().getId());
            product.setQuantity(cartList.get(i).getProduct().getQuantity() - cartList.get(i).getQuantity());
            iProductService.saveProduct(product);
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setQuantity(cartList.get(i).getQuantity());
            orderDetail.setProduct(cartList.get(i).getProduct());
            orderDetail.setCustomer(customer);
            orderDetail.setOrders(orders);
            orderDetail.setPrice(cartList.get(i).getProduct().getPrice());
            iOrderDetailService.saveOrderDetail(orderDetail);
            iCartService.deleteCart(cartList.get(i));
        }
    }
    @GetMapping("/getAllOrder")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<List<Orders>> getAllOrder(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = iAccountService.findByUsername(username);
        Customer customer = iCustomerService.findUsersId(account.getId());
        List<Orders> ordersList=iOrderService.getAllOrDerByIdCustomer(customer.getId());
        List<Orders> sortedOrders = ordersList.stream()
                .sorted(Comparator.comparing(Orders::getCreateDate).reversed())
                .collect(Collectors.toList());
        return new ResponseEntity<>(sortedOrders, HttpStatus.OK);
    }
}
