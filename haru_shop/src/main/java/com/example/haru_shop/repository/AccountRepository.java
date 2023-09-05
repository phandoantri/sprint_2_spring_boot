package com.example.haru_shop.repository;

import com.example.haru_shop.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByUsername(String username);
//    Account findByEmail(String email);

    @Query(value = "select * from account where account.username= :username ",nativeQuery = true)
    Account getByUsername(@Param("username") String username);
    @Modifying
    @Query(value = "UPDATE account SET password = :password WHERE id = :id", nativeQuery = true)
    void saveNewPassword(@Param("id") Long id, @Param("password") String password);
}
