package com.bridgelabz.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.scheduler.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
