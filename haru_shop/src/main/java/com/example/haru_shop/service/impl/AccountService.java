package com.example.haru_shop.service.impl;

import com.example.haru_shop.config.JwtUserDetails;
import com.example.haru_shop.model.Account;
import com.example.haru_shop.repository.AccountRepository;
import com.example.haru_shop.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class AccountService implements UserDetailsService, IAccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        String role = account.getRole().getName();
        authorities.add(new SimpleGrantedAuthority(role));

        return new JwtUserDetails(account.getId(), account.getUsername(), account.getPassword(), authorities);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }



    @Transactional
    @Override
    public void editUser(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void saveNewPassword(Account account) {
        Account account1 = findById(account.getId());
        String password = passwordEncoder.encode(account.getPassword());
        account1.setPassword(password);
        accountRepository.saveNewPassword(account1.getId(), account1.getPassword());
    }

}
