package com.bankApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankApp.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
