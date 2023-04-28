package com.bankApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankApp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
