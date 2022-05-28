package com.ram.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.demo.user.User;

@Repository
public interface UserRepositoryInterface extends JpaRepository<User, Long>{

}
