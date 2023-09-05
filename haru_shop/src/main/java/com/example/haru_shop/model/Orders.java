package com.example.haru_shop.model;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Orders() {
    }

    public Orders(Long id, LocalDateTime createDate, Customer customer) {
        this.id = id;
        this.createDate = createDate;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
