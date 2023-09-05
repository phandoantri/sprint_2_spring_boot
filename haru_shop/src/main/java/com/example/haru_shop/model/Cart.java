package com.example.haru_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Cart() {
    }

    public Cart(Long id, int quantity, boolean isDelete, Product product, Customer customer) {
        this.id = id;
        this.quantity = quantity;
        this.isDelete = isDelete;
        this.product = product;
        this.customer = customer;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
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
