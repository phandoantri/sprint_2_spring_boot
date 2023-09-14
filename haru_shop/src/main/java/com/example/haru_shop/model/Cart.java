package com.example.haru_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
   

    public Cart() {
    }

    public Cart(Long id, int quantity, Customer customer, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.customer = customer;
        this.product = product;
    }

    public Cart(int quantity, Product product, Customer customer) {
        this.quantity = quantity;
        this.customer = customer;
        this.product = product;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
