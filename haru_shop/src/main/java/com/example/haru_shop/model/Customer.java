package com.example.haru_shop.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dayOfBirth;
    private String address;
    private String phoneNumber;
    private int gender;
    private String email;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Customer() {
    }

    public Customer(Long id, String name, LocalDate dayOfBirth, String address, String phoneNumber, int gender, String email, Account account) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
