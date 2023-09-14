package com.example.haru_shop.service;

import com.example.haru_shop.model.Account;

public interface IAccountService {
    Account findByUsername(String username);

    void editUser(Account users);

    Account findById(Long id);
    void saveNewPassword(Account users);

}
