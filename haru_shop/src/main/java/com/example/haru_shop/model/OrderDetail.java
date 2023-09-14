package com.example.haru_shop.model;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private int quantity;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;
    @ManyToOne
    @JoinColumn(columnDefinition = "id_user")
    private Customer customer;

    public OrderDetail() {
    }


    public OrderDetail(Long id, double price, int quantity, LocalDateTime createDate, LocalDateTime updateDate, boolean isDelete, Product product, Orders orders, Customer customer) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isDelete = isDelete;
        this.product = product;
        this.orders = orders;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
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

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
