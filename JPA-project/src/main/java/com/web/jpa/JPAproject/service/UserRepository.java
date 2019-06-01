package com.web.jpa.JPAproject.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.jpa.JPAproject.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
